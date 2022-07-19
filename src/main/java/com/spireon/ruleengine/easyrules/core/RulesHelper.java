package com.spireon.ruleengine.easyrules.core;

import com.spireon.ruleengine.easyrules.core.event.EnhancedRules;
import com.spireon.ruleengine.easyrules.core.event.TelemetryEvent;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.api.*;
import org.jeasy.rules.core.RuleBuilder;
import org.jeasy.rules.support.composite.UnitRuleGroup;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Slf4j
public class RulesHelper {

    private static final RulesHelper rulesHelper = new RulesHelper();

    public static RulesHelper getInstance() {
        return rulesHelper;
    }

    public Rules createRules(RuleDefinitionGroup ruleDefinitionGroup) {
        switch (ruleDefinitionGroup.getRuleDefinitionGroupOperator()) {
            case AND: {
                UnitRuleGroup unitRuleGroup = new UnitRuleGroup();
                ruleDefinitionGroup.getRuleDefinitions().stream().forEach(ruleDefinition -> {
                    unitRuleGroup.addRule(createRule(ruleDefinition));
                });


                EnhancedRules rules = new EnhancedRules();
                rules.setRuleListener(new RuleListener() {
                    @Override
                    public void onSuccess(Rule rule, Facts facts) {
                        log.info("onSuccess.");
                    }


                    @Override
                    public void onFailure(Rule rule, Facts facts, Exception exception) {
                        log.info("onFailure.");
                    }

                    public boolean beforeEvaluate(Rule rule, Facts facts) {
                        log.info("beforeEvaluate.");

                        return true;
                    }

                    public void afterEvaluate(Rule rule, Facts facts, boolean evaluationResult) {
                        log.info("afterEvaluate.");

                    }

                    public void onEvaluationError(Rule rule, Facts facts, Exception exception) {
                        log.info("onEvaluationError.");

                    }

                    public void beforeExecute(Rule rule, Facts facts) {
                        log.info("beforeExecute.");

                    }
                });
                rules.register(unitRuleGroup);
                return rules;
            }
        }
        throw new IllegalStateException("RuleDefinitionGroup operator " + ruleDefinitionGroup.getRuleDefinitionGroupOperator() + " is not handled");

    }

    private Rule createRule(RuleDefinition ruleDefinition) {

        return new RuleBuilder()
                .name(ruleDefinition.getName())
                .description(ruleDefinition.getDescription())
                .when(createCondition(ruleDefinition))
//                .then(createAction(ruleDefinition))
                .build();
    }

    private Condition createCondition(RuleDefinition ruleDefinition) {

        return new Condition() {
            @Override
            public boolean evaluate(Facts facts) {
                TelemetryEvent telemetryEvent = getTelemetryEventObject(ruleDefinition, facts);
                String property = ruleDefinition.getProperty();
                Object value = ruleDefinition.getValue();
                ValueType valueType = ruleDefinition.getValueType();
                Operator operator = ruleDefinition.getOperator();

                Object propertyValue = getPropertyValue(telemetryEvent, property);

                log.info("property value is {}", propertyValue);
                log.info("valueType is {}", valueType);
                log.info("operator is {}", operator);

                switch (valueType) {
                    case DOUBLE: {
                        double d = Double.parseDouble((String) propertyValue);
                        switch (operator) {
                            case GREATER_THAN:
                                return d > Double.parseDouble((String) value);
                            case LESS_THAN:
                                return d < Double.parseDouble((String) value);
                            case LESS_THAN_OR_EQUAL:
                                return d <= Double.parseDouble((String) value);
                        }
                    }
                    case INTEGER: {
                        int d = Integer.parseInt((String) propertyValue);
                        switch (operator) {
                            case GREATER_THAN:
                                return d > Integer.parseInt((String) value);
                            case LESS_THAN:
                                return d < Integer.parseInt((String) value);
                            case LESS_THAN_OR_EQUAL:
                                return d <= Integer.parseInt((String) value);
                        }
                    }
                    case List: {
                        switch (operator) {
                            case IN_LIST_OF_STRING: {
                                List<String> a = (List<String>) value;
                                List<String> b = (List<String>) propertyValue;
                                for (String aa : a) {
                                    for (String bb : b) {
                                        log.info("comparing {} and {}", aa, bb);
                                        if (aa.equals(bb)) {
                                            return true;
                                        }
                                    }
                                }
                                return false;
                            }
                        }
                    }
                }
                throw new IllegalStateException("not handled for " + valueType + " in " + ruleDefinition);
            }
        };
    }

    private Action createAction(RuleDefinition ruleDefinition) {
        return new Action() {
            @Override
            public void execute(Facts facts) throws Exception {
                StringBuilder sb = new StringBuilder();
                sb.append("Alert condition satisfied for ")
                        .append(ruleDefinition.toString())
                        .append("on Telemetry object ")
                        .append(getTelemetryEventObject(ruleDefinition, facts));
                log.info("ACTION - {}", sb);
            }
        };
    }

    private Object getPropertyValue(TelemetryEvent telemetryEvent, String property) {
        log.info("Get Property Value - {} on {}", property, telemetryEvent.getClass());
        Object object = telemetryEvent;
        for (String prop : property.split("\\.")) {
            object = getValue(object, "get" + prop);
        }
        return object;

    }

    private Object getValue(Object object, String property) {
        log.info("calling {} on {}", property, object.getClass());

        try {
            Method method = object.getClass().getDeclaredMethod(property);
            return method.invoke(object);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }


    private TelemetryEvent getTelemetryEventObject(RuleDefinition ruleDefinition, Facts facts) {
        return facts.get(ruleDefinition.getEventObjectName());
    }

}

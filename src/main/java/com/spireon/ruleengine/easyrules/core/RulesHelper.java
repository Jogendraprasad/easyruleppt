package com.spireon.ruleengine.easyrules.core;

import com.spireon.ruleengine.easyrules.core.event.TelemetryEvent;
import org.jeasy.rules.api.*;
import org.jeasy.rules.core.RuleBuilder;
import org.jeasy.rules.support.composite.UnitRuleGroup;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class RulesHelper {

    private static final RulesHelper rulesHelper = new RulesHelper();

    public static RulesHelper getInstance() {
        return rulesHelper;
    }


    public Rules createRules(RuleDefinition ruleDefinition) {
        Rules rules = new Rules();
        rules.register(createRule(ruleDefinition));
        return rules;
    }

    public Rules createRules(RuleDefinitionGroup ruleDefinitionGroup) {
        switch (ruleDefinitionGroup.getRuleDefinitionGroupOperator()) {
            case AND: {
                UnitRuleGroup unitRuleGroup = new UnitRuleGroup();
                ruleDefinitionGroup.getRuleDefinitions().stream().forEach(ruleDefinition -> {
                    unitRuleGroup.addRule(createRule(ruleDefinition));
                });

                Rules rules = new Rules();
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
                .then(createAction(ruleDefinition))
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
                System.out.println("property value is " + propertyValue);
                System.out.println("valueType is " + valueType);
                System.out.println("operator is " + operator);

                switch (valueType) {
                    case DOUBLE: {
                        double d = Double.parseDouble((String) propertyValue);
                        switch (operator) {
                            case GREATER_THAN:
                                return d > Double.parseDouble((String) value);
                        }
                    }
                    case List: {
                        switch (operator) {
                            case IN_LIST_OF_STRING: {
                                List<String> a = (List<String>) value;
                                List<String> b = (List<String>) propertyValue;
                                for (String aa : a) {
                                    for (String bb : b) {
                                        System.out.println("comparing " + aa + " and " + bb);
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
                System.out.println("" + sb);
            }
        };
    }

    private Object getPropertyValue(TelemetryEvent telemetryEvent, String property) {
        System.out.println("Get Property Value - " + property + " on " + telemetryEvent.getClass());
        Object object = telemetryEvent;
        for (String prop : property.split("\\.")) {
            object = getValue(object, "get" + prop);
        }
        return object;

    }

    private Object getValue(Object object, String property) {
        System.out.println("calling " + property + " on " + object.getClass());

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

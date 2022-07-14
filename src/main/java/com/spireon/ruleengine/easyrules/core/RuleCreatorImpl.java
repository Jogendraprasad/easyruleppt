package com.spireon.ruleengine.easyrules.core;

import com.spireon.ruleengine.easyrules.core.event.TelemetryEvent;
import org.jeasy.rules.api.Action;
import org.jeasy.rules.api.Condition;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.core.RuleBuilder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class RuleCreatorImpl implements RuleCreator{
    RuleDefinition ruleDefinition;
    public RuleCreatorImpl(RuleDefinition ruleDefinition){
        this.ruleDefinition = ruleDefinition;

    }

    @Override
    public Rule createRule() {
        return createRule(ruleDefinition);
    }

//    @Override
    public Rule createRule(RuleDefinition ruleDefinition) {
        return new RuleBuilder()
                .name(ruleDefinition.getName())
                .description(ruleDefinition.getDescription())
                .when(createCondition(ruleDefinition))
                .then(createAction(ruleDefinition))
                .build();
    }

//    @Override
    public Condition createCondition(RuleDefinition ruleDefinition) {

        return new Condition() {
            @Override
            public boolean evaluate(Facts facts) {
                TelemetryEvent telemetryEvent  = getTelemetryEventObject(ruleDefinition, facts);
                String property = ruleDefinition.getProperty();
                String value = ruleDefinition.getValue();
                ValueType valueType = ruleDefinition.getValueType();
                Operator operator = ruleDefinition.getOperator();

                String propertyValue = getPropertyValue(telemetryEvent, property);
                switch (valueType){
                    case DOUBLE : {
                        double d = Double.parseDouble(propertyValue);
                        switch (operator){
                            case GREATER_THAN:
                                return d > Double.parseDouble(value);
                        }
                    }

                }

                throw new IllegalStateException("not handled for "+ruleDefinition);
            }
        };
    }

//    @Override
    public Action createAction(RuleDefinition ruleDefinition) {
        return new Action() {
            @Override
            public void execute(Facts facts) throws Exception {
                StringBuilder sb = new StringBuilder();
                sb.append("Alert condition satisfied for ")
                        .append(ruleDefinition.toString())
                        .append("on Telemetry object ")
                        .append(getTelemetryEventObject(ruleDefinition, facts));
                System.out.println(""+sb.toString());
            }
        };
    }

    private String getPropertyValue(TelemetryEvent telemetryEvent, String property){
        System.out.println("Get Property Value - "+property+" on "+telemetryEvent.getClass());
        Object object = telemetryEvent;
        for (String prop : property.split("\\.")) {
            object = getValue(object, "get"+prop);
        }
        return (String)object;

    }

    private Object getValue(Object object, String property){
        System.out.println("calling "+property+" on "+object.getClass());

        try {
            Method method = object.getClass().getDeclaredMethod(property);
            return method.invoke(object);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }


    private TelemetryEvent getTelemetryEventObject(RuleDefinition ruleDefinition, Facts facts){
        return (TelemetryEvent) facts.get(ruleDefinition.getEventObjectName());
    }


}

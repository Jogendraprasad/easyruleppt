package com.spireon.ruleengine.easyrules.core;

import lombok.Data;

@Data
public class RuleDefinition {

    private String name;
    private String description;
    private String property;
    private Object value; // for landmarks it could be list of string
    private ValueType valueType;
    private Operator operator;

    private String eventObjectName;

    public RuleDefinition(String name,
                          String description,
                          String property,
                          Object value,
                          ValueType valueType,
                          Operator operator,
                          String eventObjectName) {
        this.name = name;
        this.description = description;
        this.property = property;
        this.value = value;
        this.valueType = valueType;
        this.operator = operator;
        this.eventObjectName = eventObjectName;
    }

    public RuleDefinition() {
    }

}

package com.spireon.ruleengine.easyrules.core;

public class RuleDefinition {

    private String name;
    private String description;
    private String property;
    private String value;
    private ValueType valueType;
    private Operator operator;

    private String eventObjectName;

    public RuleDefinition(String name,
                          String description,
                          String property,
                          String value,
                          ValueType valueType,
                          Operator operator,
                          String eventObjectName){
        this.name = name;
        this.description = description;
        this.property = property;
        this.value = value;
        this.valueType = valueType;
        this.operator = operator;
        this.eventObjectName = eventObjectName;
    }
    public RuleDefinition(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ValueType getValueType() {
        return valueType;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public String getEventObjectName() {
        return eventObjectName;
    }

    public void setEventObjectName(String eventObjectName) {
        this.eventObjectName = eventObjectName;
    }

    @Override
    public String toString() {
        return "RuleDefinition{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", property='" + property + '\'' +
                ", value='" + value + '\'' +
                ", valueType=" + valueType +
                ", operator=" + operator +
                ", eventObjectName='" + eventObjectName + '\'' +
                '}';
    }
}

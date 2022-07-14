package com.spireon.ruleengine.easyrules.core;

public class RuleDefinitionGroup {

    RuleDefinition ruleDefinitionFirst;
    RuleDefinition ruleDefinitionSecond;
    RuleDefinitionGroupOperator ruleDefinitionGroupOperator;

    public RuleDefinition getRuleDefinitionFirst() {
        return ruleDefinitionFirst;
    }

    public void setRuleDefinitionFirst(RuleDefinition ruleDefinitionFirst) {
        this.ruleDefinitionFirst = ruleDefinitionFirst;
    }

    public RuleDefinition getRuleDefinitionSecond() {
        return ruleDefinitionSecond;
    }

    public void setRuleDefinitionSecond(RuleDefinition ruleDefinitionSecond) {
        this.ruleDefinitionSecond = ruleDefinitionSecond;
    }

    public RuleDefinitionGroupOperator getRuleDefinitionGroupOperator() {
        return ruleDefinitionGroupOperator;
    }

    public void setRuleDefinitionGroupOperator(RuleDefinitionGroupOperator ruleDefinitionGroupOperator) {
        this.ruleDefinitionGroupOperator = ruleDefinitionGroupOperator;
    }

    @Override
    public String toString() {
        return "RuleDefinitionGroup{" +
                "ruleDefinitionFirst=" + ruleDefinitionFirst +
                ", ruleDefinitionSecond=" + ruleDefinitionSecond +
                ", ruleDefinitionGroupOperator=" + ruleDefinitionGroupOperator +
                '}';
    }
}

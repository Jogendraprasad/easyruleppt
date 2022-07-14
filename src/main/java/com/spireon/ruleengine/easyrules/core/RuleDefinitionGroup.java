package com.spireon.ruleengine.easyrules.core;

import java.util.List;

public class RuleDefinitionGroup {

    List<RuleDefinition> ruleDefinitions;

    private RuleDefinitionGroupOperator ruleDefinitionGroupOperator;

    public List<RuleDefinition> getRuleDefinitions() {
        return ruleDefinitions;
    }

    public void setRuleDefinitions(List<RuleDefinition> ruleDefinitions) {
        this.ruleDefinitions = ruleDefinitions;
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
                "ruleDefinitions=" + ruleDefinitions +
                ", ruleDefinitionGroupOperator=" + ruleDefinitionGroupOperator +
                '}';
    }
}

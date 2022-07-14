package com.spireon.ruleengine.easyrules.core;

import lombok.Data;

import java.util.List;

@Data
public class RuleDefinitionGroup {

    List<RuleDefinition> ruleDefinitions;

    private RuleDefinitionGroupOperator ruleDefinitionGroupOperator;
}

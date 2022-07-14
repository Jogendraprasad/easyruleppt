package com.spireon.ruleengine.easyrules.core;

import org.jeasy.rules.api.Action;
import org.jeasy.rules.api.Condition;
import org.jeasy.rules.api.Rule;

public interface RuleCreator {

    Rule createRule();

//    Rule createRule(RuleDefinition ruleDefinition);
//
//    Condition createCondition(RuleDefinition ruleDefinition);
//    Action createAction(RuleDefinition ruleDefinition);
}

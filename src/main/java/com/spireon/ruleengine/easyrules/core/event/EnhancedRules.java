package com.spireon.ruleengine.easyrules.core.event;

import lombok.Data;
import org.jeasy.rules.api.RuleListener;
import org.jeasy.rules.api.Rules;

@Data
public class EnhancedRules extends Rules {
    private RuleListener ruleListener;
}

package com.spireon.ruleengine.easyrules;

import com.spireon.ruleengine.easyrules.core.Operator;
import com.spireon.ruleengine.easyrules.core.RuleCreatorImpl;
import com.spireon.ruleengine.easyrules.core.RuleDefinition;
import com.spireon.ruleengine.easyrules.core.ValueType;
import com.spireon.ruleengine.easyrules.core.event.MovementSegment;
import com.spireon.ruleengine.easyrules.core.event.TelemetryEvent;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

public class Alerter {

    private void start(){

        //Rule Object
        RuleDefinition ruleDefinition = new RuleDefinition(
                "Speed Rule",
                "Detects speed violations",
                "MovementSegment.Speed",
                "50.5",
                ValueType.DOUBLE,
                Operator.GREATER_THAN,
                "telemetryEvent"
        );
        Rule rule = new RuleCreatorImpl(ruleDefinition).createRule();
        System.out.println("Create rule successfully "+rule);
        Rules rules = new Rules(rule);

        //Event Object
        TelemetryEvent telemetryEvent = new TelemetryEvent();
        MovementSegment movementSegment = new MovementSegment();
        movementSegment.setSpeed("50.6");
        telemetryEvent.setMovementSegment(movementSegment);

        Facts facts = new Facts();
        facts.put("telemetryEvent",telemetryEvent);

        //Fire rules with facts
        RulesEngine rulesEngine = new DefaultRulesEngine();

        rulesEngine.fire(rules, facts);

    }

    public static void main(String[] args) {
        Alerter alerter = new Alerter();
        alerter.start();
    }
}

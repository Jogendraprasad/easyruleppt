package com.spireon.ruleengine.easyrules;

import com.spireon.ruleengine.easyrules.core.*;
import com.spireon.ruleengine.easyrules.core.event.LocationSegment;
import com.spireon.ruleengine.easyrules.core.event.MovementSegment;
import com.spireon.ruleengine.easyrules.core.event.TelemetryEvent;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

import java.util.ArrayList;
import java.util.List;


@Slf4j
public class Alerter {

    public static void main(String[] args) {
        Alerter alerter = new Alerter();
        alerter.start();
    }

    private void start() {

//        ruleDefinition();

        ruleDefinitionGroup();

    }

    private void ruleDefinitionGroup() {
        //Rule Object
        RuleDefinition ruleDefinitionFirst = new RuleDefinition(
                "Speed Rule",
                "Detects speed violations",
                "MovementSegment.Speed",
                "50.6",
                ValueType.DOUBLE,
                Operator.GREATER_THAN,
                "telemetryEvent"
        );
        List<String> list = new ArrayList<>();
        list.add("landmark-1");
        list.add("landmark-2");

        RuleDefinition ruleDefinitionSecond = new RuleDefinition(
                "Landmark Rule",
                "Detects landmark violations",
                "LocationSegment.Locations",
                list,
                ValueType.List,
                Operator.IN_LIST_OF_STRING,
                "telemetryEvent"
        );
        RuleDefinitionGroup ruleDefinitionGroup = new RuleDefinitionGroup();
        List<RuleDefinition> ruleDefinitions = new ArrayList<>();
        ruleDefinitions.add(ruleDefinitionFirst);
        ruleDefinitions.add(ruleDefinitionSecond);
        ruleDefinitionGroup.setRuleDefinitions(ruleDefinitions);
        ruleDefinitionGroup.setRuleDefinitionGroupOperator(RuleDefinitionGroupOperator.AND);

        Rules rules = RulesHelper.getInstance().createRules(ruleDefinitionGroup);
        System.out.println("Create rule successfully " + rules);

        //Event Object
        TelemetryEvent telemetryEvent = new TelemetryEvent();
        MovementSegment movementSegment = new MovementSegment();
        movementSegment.setSpeed("50.9");
        telemetryEvent.setMovementSegment(movementSegment);

        LocationSegment locationSegment = new LocationSegment();
        List<String> locations = new ArrayList<>();
        locations.add("landmark-3");
        locations.add("landmark-1");

        locationSegment.setLocations(locations);

        telemetryEvent.setLocationSegment(locationSegment);

        Facts facts = new Facts();
        facts.put("telemetryEvent", telemetryEvent);

        //Fire rules with facts
        RulesEngine rulesEngine = new DefaultRulesEngine();

        rulesEngine.fire(rules, facts);
    }

    private void ruleDefinition() {
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
        Rules rules = RulesHelper.getInstance().createRules(ruleDefinition);
        System.out.println("Create rule successfully " + rules);

        //Event Object
        TelemetryEvent telemetryEvent = new TelemetryEvent();
        MovementSegment movementSegment = new MovementSegment();
        movementSegment.setSpeed("50.6");
        telemetryEvent.setMovementSegment(movementSegment);

        Facts facts = new Facts();
        facts.put("telemetryEvent", telemetryEvent);

        //Fire rules with facts
        RulesEngine rulesEngine = new DefaultRulesEngine();

        rulesEngine.fire(rules, facts);
    }
}

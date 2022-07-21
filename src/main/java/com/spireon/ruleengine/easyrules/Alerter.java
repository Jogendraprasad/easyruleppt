package com.spireon.ruleengine.easyrules;

import com.spireon.platform.alerting.cdm.dto.alertconfig.LandmarkFilter;
import com.spireon.platform.alerting.cdm.dto.alertconfig.LandmarkFilterOperator;
import com.spireon.platform.alerting.cdm.dto.alertconfig.fleet.AlertTypeFleetSpeedThresholdConfig;
import com.spireon.ruleengine.easyrules.core.*;
import com.spireon.ruleengine.easyrules.core.event.EnhancedRules;
import com.spireon.ruleengine.easyrules.core.event.LocationSegment;
import com.spireon.ruleengine.easyrules.core.event.MovementSegment;
import com.spireon.ruleengine.easyrules.core.event.TelemetryEvent;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.core.DefaultRulesEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Slf4j
public class Alerter {

    public static void main(String[] args) {
        Alerter alerter = new Alerter();
        alerter.start();
    }

    private void start() {

        ruleDefinition();

//        ruleDefinitionGroup();

    }

    private void executeFleetSpeedThreshold() {
        AlertTypeFleetSpeedThresholdConfig alertTypeFleetSpeedThresholdConfig = new AlertTypeFleetSpeedThresholdConfig();
        alertTypeFleetSpeedThresholdConfig.setSpeedThresholdMPH("40");

        LandmarkFilter landmarkFilter = new LandmarkFilter();
        landmarkFilter.setProperty("landmarkid");
        landmarkFilter.setOperator(LandmarkFilterOperator.in);
        landmarkFilter.setValue(List.of("landmark-1"));
        alertTypeFleetSpeedThresholdConfig.setSelectedLandmarkFilters(List.of(landmarkFilter));

        /**
         * TODO - Convert BaseConfig to RuleDefinitions
         *
         * We have alertType code as one of the input.
         * based on the alertTypeCode we could map the Config object.
         * Iterate all the properties of the Config object and where we have non null values, put these into RuleDefinition.
         *
         * How to map configuration property name with RuleDefinition property and from where to pull Value?
         *      Will we have another mapping for this????
         *
         * */


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

        RuleDefinitionGroup ruleDefinitionGroup = createRuleDefinitionGroup(ruleDefinitionFirst, ruleDefinitionSecond);

        Rules rules = RulesHelper.getInstance().createRules(ruleDefinitionGroup);
        log.info("Create rule successfully - {}", rules);

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
        DefaultRulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.registerRuleListener(((EnhancedRules) rules).getRuleListener());

        rulesEngine.fire(rules, facts);
    }

    private RuleDefinitionGroup createRuleDefinitionGroup(RuleDefinition... ruleDefinitions) {
        return createRuleDefinitionGroup(RuleDefinitionGroupOperator.AND, ruleDefinitions);
    }

    private RuleDefinitionGroup createRuleDefinitionGroup(RuleDefinitionGroupOperator ruleDefinitionGroupOperator, RuleDefinition... ruleDefinitions) {
        RuleDefinitionGroup ruleDefinitionGroup = new RuleDefinitionGroup();
        ruleDefinitionGroup.setRuleDefinitionGroupOperator(ruleDefinitionGroupOperator);
        Arrays.stream(ruleDefinitions).forEach(ruleDefinition -> {
            ruleDefinitionGroup.getRuleDefinitions().add(ruleDefinition);
        });
        return ruleDefinitionGroup;
    }


    private void ruleDefinition() {

        //INPUT Starts ===================
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

        //Event Object

        TelemetryEvent telemetryEvent = new TelemetryEvent();
        MovementSegment movementSegment = new MovementSegment();
        movementSegment.setSpeed("50.9");
        telemetryEvent.setMovementSegment(movementSegment);

        Facts facts = new Facts();
        facts.put("telemetryEvent", telemetryEvent);

        //INPUT Ends ============================


        Rules rules = RulesHelper.getInstance().createRules(createRuleDefinitionGroup(ruleDefinition));
        log.info("Create rule successfully - {}", rules);

        //Fire rules with facts
        DefaultRulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.registerRuleListener(((EnhancedRules) rules).getRuleListener());

        rulesEngine.fire(rules, facts);
    }
}

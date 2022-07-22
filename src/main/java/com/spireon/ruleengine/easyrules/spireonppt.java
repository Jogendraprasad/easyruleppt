package com.spireon.ruleengine.easyrules;

import org.jeasy.rules.api.*;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RuleBuilder;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.support.composite.UnitRuleGroup;
import org.jeasy.rules.support.reader.YamlRuleDefinitionReader;
import com.spireon.ruleengine.easyrules.core.event.MovementSegment;
import com.spireon.ruleengine.easyrules.core.event.TelemetryEvent;

import java.io.FileReader;

public class spireonppt {
    public static void main(String[] args) throws Exception {
        TelemetryEvent telemetryevent = new TelemetryEvent();
        MovementSegment movementsegment = new MovementSegment();
        movementsegment.setSpeed("50");
        movementsegment.settyrepressure(30);
        telemetryevent.setMovementSegment(movementsegment);
        Facts facts = new Facts();
        facts.put("telemetryevent", telemetryevent);

        /*----- High speed*/
        Condition condition1 = new Condition() {
            @Override
            public boolean evaluate(Facts facts) {
                TelemetryEvent event = facts.get("telemetryevent");
                MovementSegment movseg = event.getMovementSegment();
                return Integer.parseInt(movseg.getSpeed()) > 40;
            }
        };
        Action action1 = new Action() {
            @Override
            public void execute(Facts facts) throws Exception {
                System.out.println("over speed");
            }
        };

        Rule overspeedrule = new RuleBuilder()
                .name("over speed")
                .description("checking for over speed")
                .priority(1)
                .when(condition1)
                .then(action1)
                .build();

        String filename = args.length != 0 ? args[0]
                : "src/main/java/com/spireon/ruleengine/easyrules/lowtyrepressurerule.yml";
        MVELRuleFactory ruleFactory = new MVELRuleFactory(new YamlRuleDefinitionReader());
        Rule lowtypressurerule = ruleFactory.createRule(new FileReader(filename));

        UnitRuleGroup myunitrule = new UnitRuleGroup("myunitrulegrp", "unit of rule1 and rule2");
        myunitrule.addRule(overspeedrule);
        myunitrule.addRule(lowtypressurerule);

        Rules rules = new Rules();
        rules.register(overspeedrule);
        rules.register(lowtypressurerule);
        rules.register(myunitrule);
        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, facts);
    }
}

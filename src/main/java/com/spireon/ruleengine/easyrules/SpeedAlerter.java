package com.spireon.ruleengine.easyrules;

import com.spireon.ruleengine.easyrules.events.SpeedEvent;
import org.jeasy.rules.api.*;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RuleBuilder;


public class SpeedAlerter {


    static String FACT_NAME_SPEED_EVENT = "speedEvent";

    private final double speedThreshold = 50;

    public static void main(String[] args) {

        new SpeedAlerter().run();

    }

    private void run() {


        //Event
        SpeedEvent speedEvent = new SpeedEvent(300);
        Facts facts = new Facts();
        facts.put(FACT_NAME_SPEED_EVENT, speedEvent);

        //Rules

        Rule rule = new RuleBuilder()
                .name("speed alerter")
                .description("checking for high speed")
                .priority(1)
                .when(new Condition() {
                    @Override
                    public boolean evaluate(Facts facts) {
                        SpeedEvent speedEvent1 = facts.get(FACT_NAME_SPEED_EVENT);

                        return speedEvent1.getSpeed() > speedThreshold;
                    }
                })
                .then(new Action() {
                    @Override
                    public void execute(Facts facts) throws Exception {
                        SpeedEvent speedEvent1 = facts.get(FACT_NAME_SPEED_EVENT);


                        System.out.println("threshold crossed - " + speedEvent1.getSpeed());
                    }
                })
                .build();

        Rules rules = new Rules();
        rules.register(rule);


        //fire

        RulesEngine rulesEngine = new DefaultRulesEngine();

        rulesEngine.fire(rules, facts);

    }
}

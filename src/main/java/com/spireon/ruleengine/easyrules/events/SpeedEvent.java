package com.spireon.ruleengine.easyrules.events;

public class SpeedEvent {
    private final double speed;

    public SpeedEvent(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }
}
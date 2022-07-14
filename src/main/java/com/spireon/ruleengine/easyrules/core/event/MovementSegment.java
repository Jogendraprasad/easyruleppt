package com.spireon.ruleengine.easyrules.core.event;

public class MovementSegment {
    private String speed;

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "MovementSegment{" +
                "speed='" + speed + '\'' +
                '}';
    }
}

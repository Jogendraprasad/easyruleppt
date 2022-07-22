package com.spireon.ruleengine.easyrules.core.event;

public class MovementSegment {
    private String speed;
    private Integer tyrepressure;

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public Integer gettyrepressure() {
        return tyrepressure;
    }

    public void settyrepressure(Integer tyrepressure) {
        this.tyrepressure = tyrepressure;
    }

    @Override
    public String toString() {
        return "MovementSegment{" +
                "speed='" + speed + '\'' + "tyre pressure='" + tyrepressure + '\'' +
                '}';
    }
}

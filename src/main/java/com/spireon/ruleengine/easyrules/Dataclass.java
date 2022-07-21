package com.spireon.ruleengine.easyrules;

public class Dataclass {

    private final int speed;
    private final int odometer;
    private final int tyrepressure;
    public String companyname;

    public Dataclass(int speed, int odometer, int tyrepressure, String companyname) {
        this.speed = speed;
        this.odometer = odometer;
        this.tyrepressure = tyrepressure;
        this.companyname = companyname;
    }

    public int getSpeed() {
        return speed;
    }


    public int getOdometer() {
        return odometer;
    }

    public int getTyrepressure() {
        return tyrepressure;
    }


}

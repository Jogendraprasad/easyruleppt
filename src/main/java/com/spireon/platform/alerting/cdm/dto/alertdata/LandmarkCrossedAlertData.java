package com.spireon.platform.alerting.cdm.dto.alertdata;


public class LandmarkCrossedAlertData extends AlertData {
    private Direction direction;
    private Boolean arrivalTrigger;
    private Boolean departureTrigger;

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Boolean isArrivalTrigger() {
        return arrivalTrigger;
    }

    public void setArrivalTrigger(Boolean arrivalTrigger) {
        this.arrivalTrigger = arrivalTrigger;
    }

    public Boolean isDepartureTrigger() {
        return departureTrigger;
    }

    public void setDepartureTrigger(Boolean departureTrigger) {
        this.departureTrigger = departureTrigger;
    }

    public enum Direction {
        ARRIVAL,
        DEPARTURE
    }
}

package com.spireon.platform.alerting.cdm.dto.alertdata;

public class HardAccelerationAlertData extends AlertData {
    private AccelerationType type;
    private Boolean brakingTrigger;
    private Boolean accelerationTrigger;

    public AccelerationType getType() {
        return type;
    }

    public void setType(AccelerationType type) {
        this.type = type;
    }

    public Boolean getBrakingTrigger() {
        return brakingTrigger;
    }

    public void setBrakingTrigger(Boolean brakingTrigger) {
        this.brakingTrigger = brakingTrigger;
    }

    public Boolean getAccelerationTrigger() {
        return accelerationTrigger;
    }

    public void setAccelerationTrigger(Boolean accelerationTrigger) {
        this.accelerationTrigger = accelerationTrigger;
    }

    public enum AccelerationType {
        BRAKING,
        ACCELERATION
    }
}

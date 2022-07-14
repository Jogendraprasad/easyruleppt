package com.spireon.platform.alerting.cdm.dto.alertdata;


public class InputChangedAlertData extends AlertData {
    private InputCode code;
    private String name;
    private InputStatus value;
    private Boolean activeTrigger;
    private Boolean inactiveTrigger;

    public InputCode getCode() {
        return code;
    }

    public void setCode(InputCode code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InputStatus getValue() {
        return value;
    }

    public void setValue(InputStatus value) {
        this.value = value;
    }

    public Boolean getActiveTrigger() {
        return activeTrigger;
    }

    public void setActiveTrigger(Boolean activeTrigger) {
        this.activeTrigger = activeTrigger;
    }

    public Boolean getInactiveTrigger() {
        return inactiveTrigger;
    }

    public void setInactiveTrigger(Boolean inactiveTrigger) {
        this.inactiveTrigger = inactiveTrigger;
    }

    public enum InputCode {
        INPUT1,
        INPUT2,
        INPUT3,
        INPUT4,
        INPUT5,
        INPUT6,
        INPUT7,
        INPUT8;
    }

    public enum InputStatus {
        ACTIVE,
        INACTIVE
    }
}

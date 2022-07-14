package com.spireon.platform.alerting.cdm.dto.alertdata;


public class LowVoltageAlertData extends AlertData {
    private BatteryType type;
    private Double voltageValue;
    private Double voltageThreshold;
    private Boolean internalLowVoltageTrigger;
    private Boolean externalLowVoltageTrigger;

    public BatteryType getType() {
        return type;
    }

    public void setType(BatteryType type) {
        this.type = type;
    }

    public Double getVoltageValue() {
        return voltageValue;
    }

    public void setVoltageValue(Double voltageValue) {
        this.voltageValue = voltageValue;
    }

    public Double getVoltageThreshold() {
        return voltageThreshold;
    }

    public void setVoltageThreshold(Double voltageThreshold) {
        this.voltageThreshold = voltageThreshold;
    }

    public Boolean getInternalLowVoltageTrigger() {
        return internalLowVoltageTrigger;
    }

    public void setInternalLowVoltageTrigger(Boolean internalLowVoltageTrigger) {
        this.internalLowVoltageTrigger = internalLowVoltageTrigger;
    }

    public Boolean getExternalLowVoltageTrigger() {
        return externalLowVoltageTrigger;
    }

    public void setExternalLowVoltageTrigger(Boolean externalLowVoltageTrigger) {
        this.externalLowVoltageTrigger = externalLowVoltageTrigger;
    }

    public enum BatteryType {
        INTERNAL,
        EXTERNAL
    }
}

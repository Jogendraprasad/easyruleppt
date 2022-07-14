package com.spireon.platform.alerting.cdm.dto.alertdata;


public class FuelTankAlertData extends AlertData {
    private Double fuelLevel;
    private Double fuelTankThreshold;
    private Boolean realertFlag;
    private Integer realertMinutes;

    public Double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(Double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public Double getFuelTankThreshold() {
        return fuelTankThreshold;
    }

    public void setFuelTankThreshold(Double fuelTankThreshold) {
        this.fuelTankThreshold = fuelTankThreshold;
    }

    public Boolean getRealertFlag() {
        return realertFlag;
    }

    public void setRealertFlag(Boolean realertFlag) {
        this.realertFlag = realertFlag;
    }

    public Integer getRealertMinutes() {
        return realertMinutes;
    }

    public void setRealertMinutes(Integer realertMinutes) {
        this.realertMinutes = realertMinutes;
    }
}

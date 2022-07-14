package com.spireon.platform.alerting.cdm.dto.alertdata;


public class SpeedLimitAlertData extends AlertData {

    private Integer zoneSpeed;
    private Integer overspeedThreshold;

    public Integer getZoneSpeed() {
        return zoneSpeed;
    }

    public void setZoneSpeed(Integer zoneSpeed) {
        this.zoneSpeed = zoneSpeed;
    }

    public Integer getOverspeedThreshold() {
        return overspeedThreshold;
    }

    public void setOverspeedThreshold(Integer overspeedThreshold) {
        this.overspeedThreshold = overspeedThreshold;
    }
}

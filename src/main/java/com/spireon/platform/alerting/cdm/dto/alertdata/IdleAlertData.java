package com.spireon.platform.alerting.cdm.dto.alertdata;


public class IdleAlertData extends AlertData {
    private Integer durationThreshold;
    private Boolean realertFlag;
    private Integer realertInterval;

    public Integer getDurationThreshold() {
        return durationThreshold;
    }

    public void setDurationThreshold(Integer durationThreshold) {
        this.durationThreshold = durationThreshold;
    }

    public Boolean getRealertFlag() {
        return realertFlag;
    }

    public void setRealertFlag(Boolean realertFlag) {
        this.realertFlag = realertFlag;
    }

    public Integer getRealertInterval() {
        return realertInterval;
    }

    public void setRealertInterval(Integer realertInterval) {
        this.realertInterval = realertInterval;
    }
}

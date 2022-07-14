package com.spireon.platform.alerting.cdm.dto.alertdata;


public class OddHoursAlertData extends AlertData {
    private Boolean realertFlag;
    private Integer realertInterval;

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

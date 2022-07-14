package com.spireon.platform.alerting.cdm.dto.alertdata;


public class StopAlertData extends AlertData {
    private Integer durationThreshold;

    public Integer getDurationThreshold() {
        return durationThreshold;
    }

    public void setDurationThreshold(Integer durationThreshold) {
        this.durationThreshold = durationThreshold;
    }
}

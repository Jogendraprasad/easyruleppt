package com.spireon.platform.alerting.cdm.dto.alertdata;


public class MaintenanceTimePeriodAlertData extends AlertData {
    private Double timePeriodInterval;
    private Double timePeriodThreshold;

    public Double getTimePeriodInterval() {
        return timePeriodInterval;
    }

    public void setTimePeriodInterval(Double timePeriodInterval) {
        this.timePeriodInterval = timePeriodInterval;
    }

    public Double getTimePeriodThreshold() {
        return timePeriodThreshold;
    }

    public void setTimePeriodThreshold(Double timePeriodThreshold) {
        this.timePeriodThreshold = timePeriodThreshold;
    }
}

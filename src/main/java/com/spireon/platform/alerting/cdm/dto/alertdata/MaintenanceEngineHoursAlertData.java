package com.spireon.platform.alerting.cdm.dto.alertdata;


public class MaintenanceEngineHoursAlertData extends AlertData {
    private Double engineHours;
    private Double engineHoursInterval;
    private Double engineHoursThreshold;

    public Double getEngineHours() {
        return engineHours;
    }

    public void setEngineHours(Double engineHours) {
        this.engineHours = engineHours;
    }

    public Double getEngineHoursInterval() {
        return engineHoursInterval;
    }

    public void setEngineHoursInterval(Double engineHoursInterval) {
        this.engineHoursInterval = engineHoursInterval;
    }

    public Double getEngineHoursThreshold() {
        return engineHoursThreshold;
    }

    public void setEngineHoursThreshold(Double engineHoursThreshold) {
        this.engineHoursThreshold = engineHoursThreshold;
    }
}

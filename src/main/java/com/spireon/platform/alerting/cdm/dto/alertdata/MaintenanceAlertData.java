package com.spireon.platform.alerting.cdm.dto.alertdata;


public class MaintenanceAlertData extends AlertData {
    private Double distance;
    private Double distanceInterval;
    private Double timePeriodInterval;
    private Double engineHours;
    private Double engineHoursInterval;
    private SatisfiedByThreshold satisfiedByThreshold;

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getDistanceInterval() {
        return distanceInterval;
    }

    public void setDistanceInterval(Double distanceInterval) {
        this.distanceInterval = distanceInterval;
    }

    public Double getTimePeriodInterval() {
        return timePeriodInterval;
    }

    public void setTimePeriodInterval(Double timePeriodInterval) {
        this.timePeriodInterval = timePeriodInterval;
    }

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

    public SatisfiedByThreshold getStatisfiedByThreshold() {
        return satisfiedByThreshold;
    }

    public void setSatisfiedByThreshold(SatisfiedByThreshold satisfiedByThreshold) {
        this.satisfiedByThreshold = satisfiedByThreshold;
    }

    public enum SatisfiedByThreshold {
        ODOMETER, ENGINE_HOURS, TIME_PERIOD
    }
}
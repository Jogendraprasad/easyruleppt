package com.spireon.platform.alerting.cdm.dto.alertdata;


public class TemperatureAlertData extends AlertData {
    private Double temperature;
    private BreachType breachType;
    private Double minCautionThreshold;
    private Double maxCautionThreshold;
    private Double minCriticalThreshold;
    private Double maxCriticalThreshold;

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public BreachType getBreachType() {
        return breachType;
    }

    public void setBreachType(BreachType breachType) {
        this.breachType = breachType;
    }

    public Double getMinCautionThreshold() {
        return minCautionThreshold;
    }

    public void setMinCautionThreshold(Double minCautionThreshold) {
        this.minCautionThreshold = minCautionThreshold;
    }

    public Double getMaxCautionThreshold() {
        return maxCautionThreshold;
    }

    public void setMaxCautionThreshold(Double maxCautionThreshold) {
        this.maxCautionThreshold = maxCautionThreshold;
    }

    public Double getMinCriticalThreshold() {
        return minCriticalThreshold;
    }

    public void setMinCriticalThreshold(Double minCriticalThreshold) {
        this.minCriticalThreshold = minCriticalThreshold;
    }

    public Double getMaxCriticalThreshold() {
        return maxCriticalThreshold;
    }

    public void setMaxCriticalThreshold(Double maxCriticalThreshold) {
        this.maxCriticalThreshold = maxCriticalThreshold;
    }

    public enum BreachType {
        CAUTION_MIN,
        CAUTION_MAX,
        CRITICAL_MIN,
        CRITICAL_MAX
    }
}

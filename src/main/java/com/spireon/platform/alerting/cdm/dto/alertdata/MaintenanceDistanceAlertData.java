package com.spireon.platform.alerting.cdm.dto.alertdata;


public class MaintenanceDistanceAlertData extends AlertData {
    private Double distance;
    private Double distanceInterval;
    private Double distanceThreshold;

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

    public Double getDistanceThreshold() {
        return distanceThreshold;
    }

    public void setDistanceThreshold(Double distanceThreshold) {
        this.distanceThreshold = distanceThreshold;
    }
}

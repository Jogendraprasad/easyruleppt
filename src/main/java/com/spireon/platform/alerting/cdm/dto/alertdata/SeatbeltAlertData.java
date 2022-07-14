package com.spireon.platform.alerting.cdm.dto.alertdata;


public class SeatbeltAlertData extends AlertData {
    private Integer seatbeltThreshold;
    private Boolean realertFlag;
    private Integer realertInterval;

    public Integer getSeatbeltThreshold() {
        return seatbeltThreshold;
    }

    public void setSeatbeltThreshold(Integer seatbeltThreshold) {
        this.seatbeltThreshold = seatbeltThreshold;
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

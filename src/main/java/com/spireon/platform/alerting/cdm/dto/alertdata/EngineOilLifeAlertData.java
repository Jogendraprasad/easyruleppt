package com.spireon.platform.alerting.cdm.dto.alertdata;


public class EngineOilLifeAlertData extends AlertData {
    private Double engineOilLife;
    private Boolean realertFlag;
    private Integer realertInterval;

    public Double getEngineOilLife() {
        return engineOilLife;
    }

    public void setEngineOilLife(Double engineOilLife) {
        this.engineOilLife = engineOilLife;
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
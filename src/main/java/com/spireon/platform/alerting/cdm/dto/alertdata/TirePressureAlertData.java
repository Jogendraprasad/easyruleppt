package com.spireon.platform.alerting.cdm.dto.alertdata;


public class TirePressureAlertData extends AlertData {

    private Double tirePressureLr;
    private Double tirePressureRr;
    private Double tirePressureRf;
    private Double tirePressureLf;
    private Double tirePressurePlacardFront;
    private Double tirePressurePlacardRear;

    public Double getTirePressureLr() {
        return tirePressureLr;
    }

    public void setTirePressureLr(Double tirePressureLr) {
        this.tirePressureLr = tirePressureLr;
    }

    public Double getTirePressureRr() {
        return tirePressureRr;
    }

    public void setTirePressureRr(Double tirePressureRr) {
        this.tirePressureRr = tirePressureRr;
    }

    public Double getTirePressureRf() {
        return tirePressureRf;
    }

    public void setTirePressureRf(Double tirePressureRf) {
        this.tirePressureRf = tirePressureRf;
    }

    public Double getTirePressureLf() {
        return tirePressureLf;
    }

    public void setTirePressureLf(Double tirePressureLf) {
        this.tirePressureLf = tirePressureLf;
    }

    public Double getTirePressurePlacardFront() {
        return tirePressurePlacardFront;
    }

    public void setTirePressurePlacardFront(Double tirePressurePlacardFront) {
        this.tirePressurePlacardFront = tirePressurePlacardFront;
    }

    public Double getTirePressurePlacardRear() {
        return tirePressurePlacardRear;
    }

    public void setTirePressurePlacardRear(Double tirePressurePlacardRear) {
        this.tirePressurePlacardRear = tirePressurePlacardRear;
    }
}

package com.spireon.platform.alerting.cdm.dto.alertdata;


public class OffLotAlertData extends AlertData {
    public static final String TYPE = "OffLotAlertData";

    String stockNumber;

    public String getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
    }

}

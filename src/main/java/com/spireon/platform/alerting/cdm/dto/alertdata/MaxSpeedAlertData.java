package com.spireon.platform.alerting.cdm.dto.alertdata;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

@Data
@JsonTypeName(MaxSpeedAlertData.TYPE)

public class MaxSpeedAlertData extends AlertData {
    public static final String TYPE = "MaxSpeedAlertData";

    String stockNumber;

    public String getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
    }

}

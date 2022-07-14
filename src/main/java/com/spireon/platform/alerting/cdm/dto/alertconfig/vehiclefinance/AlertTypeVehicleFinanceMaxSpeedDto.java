package com.spireon.platform.alerting.cdm.dto.alertconfig.vehiclefinance;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.spireon.platform.alerting.cdm.dto.alertconfig.AlertTypeDto;
import lombok.Data;

@JsonTypeName(AlertTypeVehicleFinanceMaxSpeedDto.CODE)
@Data
public class AlertTypeVehicleFinanceMaxSpeedDto extends AlertTypeDto {
    public static final String CODE = "alertTypeVehicleFinanceMaxSpeed";

    private AlertTypeVehicleFinanceMaxSpeedConfig config;

}

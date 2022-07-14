package com.spireon.platform.alerting.cdm.dto.alertconfig.vehiclefinance;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.spireon.platform.alerting.cdm.dto.alertconfig.AlertTypeDto;
import lombok.Data;

@JsonTypeName(AlertTypeVehicleFinanceTowAlertDto.CODE)
@Data
public class AlertTypeVehicleFinanceTowAlertDto extends AlertTypeDto {
    public static final String CODE = "alertTypeVehicleFinanceTowAlert";

    private AlertTypeVehicleFinanceTowConfig config;

}

package com.spireon.platform.alerting.cdm.dto.alertconfig;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.spireon.platform.alerting.cdm.dto.alertconfig.vehiclefinance.AlertTypeVehicleFinanceMaxSpeedDto;
import lombok.Data;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "code")
@JsonSubTypes({
        //fleet
//        @JsonSubTypes.Type(value = AlertTypeFleetCargoStatusChangeEventDto.class, name = AlertTypeFleetCargoStatusChangeEventDto.CODE),
//        @JsonSubTypes.Type(value = AlertTypeFleetDoorEventDto.class, name = AlertTypeFleetDoorEventDto.CODE),
//        @JsonSubTypes.Type(value = AlertTypeFleetLandmarkArrivalDepartureDto.class, name = AlertTypeFleetLandmarkArrivalDepartureDto.CODE),
//        @JsonSubTypes.Type(value = AlertTypeFleetLowBatteryDto.class, name = AlertTypeFleetLowBatteryDto.CODE),
//        @JsonSubTypes.Type(value = AlertTypeFleetLowExtBatteryDto.class, name = AlertTypeFleetLowExtBatteryDto.CODE),
//        @JsonSubTypes.Type(value = AlertTypeFleetPowerDisconnectedDto.class, name = AlertTypeFleetPowerDisconnectedDto.CODE),
//        @JsonSubTypes.Type(value = AlertTypeFleetPowerReconnectedDto.class, name = AlertTypeFleetPowerReconnectedDto.CODE),
//        @JsonSubTypes.Type(value = AlertTypeFleetProlongedStopDto.class, name = AlertTypeFleetProlongedStopDto.CODE),
//        @JsonSubTypes.Type(value = AlertTypeFleetSpeedThresholdDto.class, name = AlertTypeFleetSpeedThresholdDto.CODE),
//        @JsonSubTypes.Type(value = AlertTypeFleetTPMSDto.class, name = AlertTypeFleetTPMSDto.CODE),
//        @JsonSubTypes.Type(value = AlertTypeFleetUnauthorizedMovementDto.class, name = AlertTypeFleetUnauthorizedMovementDto.CODE),
//        @JsonSubTypes.Type(value = AlertTypeFleetVarianceDto.class, name = AlertTypeFleetVarianceDto.CODE),

        //vehicleFinance / Kahu
//        @JsonSubTypes.Type(value = AlertTypeVehicleFinanceGeofenceDto.class, name = AlertTypeVehicleFinanceGeofenceDto.CODE),
        @JsonSubTypes.Type(value = AlertTypeVehicleFinanceMaxSpeedDto.class, name = AlertTypeVehicleFinanceMaxSpeedDto.CODE),
//        @JsonSubTypes.Type(value = AlertTypeVehicleFinanceOffLotDto.class, name = AlertTypeVehicleFinanceOffLotDto.CODE),
//        @JsonSubTypes.Type(value = AlertTypeVehicleFinancePowerDisconnectedDto.class, name = AlertTypeVehicleFinancePowerDisconnectedDto.CODE),


        //localFleet
//        @JsonSubTypes.Type(value = LocalFleetLowBatteryAlertDto.class, name = LocalFleetLowBatteryAlertDto.CODE),
//        @JsonSubTypes.Type(value = LocalFleetTirePressureAlertDto.class, name = LocalFleetTirePressureAlertDto.CODE),
})
@Data
public abstract class AlertTypeDto {
}

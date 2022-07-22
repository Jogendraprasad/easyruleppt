package com.spireon.platform.alerting.cdm.dto.alertconfig.fleet;

import lombok.Data;

@Data
public class AlertTypeFleetSpeedThresholdConfig extends FleetBaseConfig {
    String speedThresholdMPH;
}

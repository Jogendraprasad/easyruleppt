package com.spireon.platform.alerting.cdm.dto.alertconfig;

import lombok.Data;

import java.util.List;

@Data
public abstract class BaseConfig {

    String realert;
    String realertMinutes;

    String timezone;
    String alertColor;
    //    String[] queryFields; // This is un-supported in PlatformApi
    private List<LandmarkFilter> selectedLandmarkFilters;

}

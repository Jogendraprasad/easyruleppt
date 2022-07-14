package com.spireon.platform.alerting.cdm.dto.alertconfig;

import lombok.Data;

import java.util.List;

@Data
public class LandmarkFilter {
    private String property;
    private LandmarkFilterOperator operator;
    private List<String> value;
}

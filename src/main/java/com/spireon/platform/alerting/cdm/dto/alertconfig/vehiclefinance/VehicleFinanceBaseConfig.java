package com.spireon.platform.alerting.cdm.dto.alertconfig.vehiclefinance;

import com.spireon.platform.alerting.cdm.dto.alertconfig.BaseConfig;
import lombok.Data;

@Data
public class VehicleFinanceBaseConfig extends BaseConfig {
    String[] assetSearchFields;
    String[] assetSearchTags;
    String[] assetSearchText;
    String[] landmarkSearchTags;
    String[] landmarkSearchText;
    boolean notInAssetGroup;
    boolean notInLandmarkGroup;
}

package com.spireon.platform.alerting.cdm.dto.alertdata;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = MaxSpeedAlertData.class, name = MaxSpeedAlertData.TYPE),
        @JsonSubTypes.Type(value = OffLotAlertData.class, name = OffLotAlertData.TYPE),

})
@Data
public abstract class AlertData {

}

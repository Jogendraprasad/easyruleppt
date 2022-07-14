package com.spireon.platform.alerting.cdm.dto;

import com.spireon.platform.alerting.cdm.dto.alertdata.AlertData;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

//It is copy of DeviceAlert Entity used in procon-core
@Data
public class DeviceAlertDto implements Serializable {


    String Id; //TODO: Schema analysis shows _Id;
    String globalId; //2.0 global unique Id;
    Long alertTypeId;
    Long alertSpecId;
    String alertTypeCode;
    String alertSpecGlobalId;  //New global Id for alert spec
    String eventId; //TODO: Schema analysis shows type ObjectId;
    String stateId; //TODO: Schema analysis shows type ObjectId;
    Long accountId;
    String accountGlobalId;
    Long deviceId;
    String deviceGlobalId;
    Long assetId;
    String assetGlobalId;
    Long operatorId;
    String operatorGlobalId;
    Long duration; // 5% of the time, this is Double
    String deviceName;
    String assetName;
    Long landmarkId;
    String landmarkGlobalId;
    String landmarkName;
    Long landmarkGroupId;
    String locationName;
    String alertSpecName;
    String alertTitle;
    Date alertDate;
    Date startDate;
    Date endDate;
    Date daystamp;
    Double lat;
    Double lng;
    Double odometer; //TODO: Remove since Global Probability: 0.13%. Force to use odomoter.
    Double odomoter; //Global Probability: 99.87%
    Double distance;
    Double heading;
    Double speed;
    String internalId;
    String externalId;
    String stateField;
    Date stateStart;
    String address;
    String city;
    String state;
    String zip;
    Boolean active = true;
    Boolean acknowledged = false;
    String alertOutput;
    String assetVin;
    String serialNumber;
    String alertTypeName;
    Date dateCreated;
    Double rss;
    Double extVolts;
    Long satellites;
    Double assetDistance; //TODO: Schema analysis shows this is always null.
    Double assetDistanceSum;
    Long alertHourOfDay;
    String action;
    String alertSetting; //only appears 1.4% of the time
    String alertEmailSubject;
    String alertEmailOutput;
    String smsOutput;
    Long stateDate; //TODO: 16.31% of the time, this is a Date.
    String landmarkEventId;
    Boolean landmarkOn;
    Long maintenanceAlertSpecId; //only appears 0.13% of the time
    String location; //only appears 0.13% of the time
    String recipientList;
    String inputName; //only appears 1% of the time
    String inputStatus; //only appears 1% of the time
    String direction; //only appears 1% of the time
    Long geofenceIndex; //only appears 1% of the time
    Boolean realert;
    Date realertTime;
    String eventTypeName; // only for an alert generated for acknowledgable events
    Integer totalCost; // only for an alert generated for acknowledgable events
    String operatorFirstName;
    String operatorLastName;
    String diagTroubleCodes;
    Integer assetYear;
    String assetMake;
    String assetModel;

    AlertData alertData;

//	/**
//	 * Adding hook to set the daystamp field of the
//	 * @return
//	 */
//	def beforeUpdate() {
//		if(daystamp == null || daystamp < alertDate) {
//			daystamp = DateUtility.getStartOfDateDay(this.alertDate)
//		}
//	}
//
//	def beforeInsert() {
//		beforeUpdate()
//	}
//
//
//
//	def setStateDate(def date){
//		this.stateDate = date instanceof Date? date?.getTime(): date;
//	}


}

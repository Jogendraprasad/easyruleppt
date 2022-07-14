package com.spireon.platform.alerting.cdm.dto.alertdata;


import java.util.List;


public class TPMSAlertData extends AlertData {
    private List<TPMSRecord> tpmsRecords;

    public List<TPMSRecord> getTpmsRecords() {
        return tpmsRecords;
    }

    public void setTpmsRecords(List<TPMSRecord> tpmsRecords) {
        this.tpmsRecords = tpmsRecords;
    }

    public static class TPMSRecord {
        private Integer position;
        private Boolean lowSensorBatteryAlert;
        private Boolean noDataForMoreThan60MinuteAlert;
        private Boolean inflateAlert;
        private Boolean lowTirePressureAlert;
        private Boolean highTirePressureAlert;
        private Boolean tireTemperatureAlert;
        private Boolean fastLeakAlert;

        public Integer getPosition() {
            return position;
        }

        public void setPosition(Integer position) {
            this.position = position;
        }

        public Boolean getLowSensorBatteryAlert() {
            return lowSensorBatteryAlert;
        }

        public void setLowSensorBatteryAlert(Boolean lowSensorBatteryAlert) {
            this.lowSensorBatteryAlert = lowSensorBatteryAlert;
        }

        public Boolean getNoDataForMoreThan60MinuteAlert() {
            return noDataForMoreThan60MinuteAlert;
        }

        public void setNoDataForMoreThan60MinuteAlert(Boolean noDataForMoreThan60MinuteAlert) {
            this.noDataForMoreThan60MinuteAlert = noDataForMoreThan60MinuteAlert;
        }

        public Boolean getInflateAlert() {
            return inflateAlert;
        }

        public void setInflateAlert(Boolean inflateAlert) {
            this.inflateAlert = inflateAlert;
        }

        public Boolean getLowTirePressureAlert() {
            return lowTirePressureAlert;
        }

        public void setLowTirePressureAlert(Boolean lowTirePressureAlert) {
            this.lowTirePressureAlert = lowTirePressureAlert;
        }

        public Boolean getHighTirePressureAlert() {
            return highTirePressureAlert;
        }

        public void setHighTirePressureAlert(Boolean highTirePressureAlert) {
            this.highTirePressureAlert = highTirePressureAlert;
        }

        public Boolean getTireTemperatureAlert() {
            return tireTemperatureAlert;
        }

        public void setTireTemperatureAlert(Boolean tireTemperatureAlert) {
            this.tireTemperatureAlert = tireTemperatureAlert;
        }

        public Boolean getFastLeakAlert() {
            return fastLeakAlert;
        }

        public void setFastLeakAlert(Boolean fastLeakAlert) {
            this.fastLeakAlert = fastLeakAlert;
        }
    }
}

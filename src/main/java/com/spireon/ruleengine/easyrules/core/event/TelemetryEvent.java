package com.spireon.ruleengine.easyrules.core.event;

public class TelemetryEvent {
    private String assetId;
    private MovementSegment movementSegment;
    private LocationSegment locationSegment;


    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public MovementSegment getMovementSegment() {
        return movementSegment;
    }

    public void setMovementSegment(MovementSegment movementSegment) {
        this.movementSegment = movementSegment;
    }

    public LocationSegment getLocationSegment() {
        return locationSegment;
    }

    public void setLocationSegment(LocationSegment locationSegment) {
        this.locationSegment = locationSegment;
    }

    @Override
    public String toString() {
        return "TelemetryEvent{" +
                "assetId='" + assetId + '\'' +
                ", movementSegment=" + movementSegment +
                ", locationSegment=" + locationSegment +
                '}';
    }
}

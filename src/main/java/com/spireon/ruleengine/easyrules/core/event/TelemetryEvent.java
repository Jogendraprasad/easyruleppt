package com.spireon.ruleengine.easyrules.core.event;

import lombok.Data;

@Data
public class TelemetryEvent {
    private String assetId;
    private MovementSegment movementSegment;
    private LocationSegment locationSegment;
}

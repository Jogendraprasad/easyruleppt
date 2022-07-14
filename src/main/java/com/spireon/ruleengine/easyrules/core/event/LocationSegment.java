package com.spireon.ruleengine.easyrules.core.event;

import java.util.List;

public class LocationSegment {
    List<String> locations;

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "LocationSegment{" +
                "locations=" + locations +
                '}';
    }
}

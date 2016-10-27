package com.github.vakhrymchuk.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BusRouteResponse {

    @JsonProperty("dep_sid")
    private final Integer depSid;

    @JsonProperty("arr_sid")
    private final Integer arrSid;

    @JsonProperty("direct_bus_route")
    private final Boolean directBusRoute;

    public BusRouteResponse(final Integer depSid, final Integer arrSid, final Boolean directBusRoute) {
        this.depSid = depSid;
        this.arrSid = arrSid;
        this.directBusRoute = directBusRoute;
    }
}

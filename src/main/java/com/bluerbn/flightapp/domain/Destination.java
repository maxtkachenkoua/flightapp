package com.bluerbn.flightapp.domain;

public class Destination {

    private final Long destinationId;

    public Destination(Long destinationId) {
        this.destinationId = destinationId;
    }

    public Long getDestinationId() {
        return destinationId;
    }
}

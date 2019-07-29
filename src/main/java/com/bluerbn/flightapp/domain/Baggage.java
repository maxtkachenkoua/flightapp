package com.bluerbn.flightapp.domain;

public class Baggage {

    private final String baggageId;

    public Baggage(String baggageId) {
        this.baggageId = baggageId;
    }

    public String getBaggageId() {
        return baggageId;
    }
}

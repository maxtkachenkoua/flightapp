package com.bluerbn.flightapp.domain;

public class Ticket {

    private Long ticketId;

    private Destination destination;

    private Coupon coupon;

    private Baggage baggage;

    private Double price;

    private boolean isAvailable;

    public Ticket(Long ticketId, Destination destination, Baggage baggage, Double price) {
        this.ticketId = ticketId;
        this.destination = destination;
        this.baggage = baggage;
        this.price = price;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Baggage getBaggage() {
        return baggage;
    }

    public void setBaggage(Baggage baggage) {
        this.baggage = baggage;
    }
}

package com.bluerbn.flightapp.domain;

public class Coupon {

    private final Long couponId;

    private final Double discount;

    public Coupon(Long couponId, Double discount) {
        this.couponId = couponId;
        this.discount = discount;
    }

    public Long getCouponId() {
        return couponId;
    }

    public Double getDiscount() {
        return discount;
    }
}

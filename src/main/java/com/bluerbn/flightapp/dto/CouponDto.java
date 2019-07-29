package com.bluerbn.flightapp.dto;

import com.bluerbn.flightapp.constants.CouponStatus;

public class CouponDto {

    private CouponStatus couponStatus;

    private Double price;

    public CouponStatus getCouponStatus() {
        return couponStatus;
    }

    public void setCouponStatus(CouponStatus couponStatus) {
        this.couponStatus = couponStatus;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

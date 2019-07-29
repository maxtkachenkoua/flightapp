package com.bluerbn.flightapp.service;

import com.bluerbn.flightapp.dto.CouponDto;

public interface CouponService {

    CouponDto useCoupon(Long couponId, Double price);
}

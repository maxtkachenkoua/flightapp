package com.bluerbn.flightapp.service.impl;

import com.bluerbn.flightapp.constants.CouponStatus;
import com.bluerbn.flightapp.domain.Coupon;
import com.bluerbn.flightapp.dto.CouponDto;
import com.bluerbn.flightapp.repository.FlightRepository;
import com.bluerbn.flightapp.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CouponServiceImpl implements CouponService {

    private final FlightRepository flightRepository;

    @Autowired
    public CouponServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public CouponDto useCoupon(Long couponId, Double price) {
        Optional<Coupon> couponOptional = flightRepository.findCoupon(couponId);
        CouponDto dto = new CouponDto();
        if (couponOptional.isPresent()) {
            dto.setCouponStatus(CouponStatus.COUPON_APPLIED);
            dto.setPrice(price * couponOptional.get().getDiscount());
        } else {
            dto.setCouponStatus(CouponStatus.COUPON_INVALID);
            dto.setPrice(price);
        }
        return dto;
    }
}

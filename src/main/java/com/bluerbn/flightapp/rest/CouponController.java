package com.bluerbn.flightapp.rest;

import com.bluerbn.flightapp.dto.CouponDto;
import com.bluerbn.flightapp.service.CouponService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/coupon")
public class CouponController {

    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @ApiOperation(value = "Provide Coupon support",
            notes = "User provide couponId(Numeric) and Price(Double). " +
                    "Return response if the coupon is valid. In the response the use will get the final price " +
                    "after discount (10%,50%,60% - picked up randomly) in case not valid the response should " +
                    " indicate that the coupon is not valid and the original price will be returned. " +
                    "create random list of valid couponId's", response = CouponDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Action status returned")
    })
    @RequestMapping(value = "/{couponId}/{price}", method = RequestMethod.POST)
    public ResponseEntity<CouponDto> isTicketAvailable(@PathVariable("couponId") @NotNull Long couponId,
                                                       @PathVariable("price") @NotNull Double price) {
        return ResponseEntity.ok(couponService.useCoupon(couponId, price));
    }

}

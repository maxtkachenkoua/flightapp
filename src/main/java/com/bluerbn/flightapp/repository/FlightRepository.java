package com.bluerbn.flightapp.repository;

import com.bluerbn.flightapp.domain.Baggage;
import com.bluerbn.flightapp.domain.Coupon;
import com.bluerbn.flightapp.domain.Destination;
import com.bluerbn.flightapp.domain.Ticket;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlightRepository {

    Optional<Ticket> findTicket(Long ticketId);

    Optional<Coupon> findCoupon(Long couponId);

    Optional<Destination> findDestination(Long destinationId);

    Optional<Baggage> findBaggage(String baggageId);


}

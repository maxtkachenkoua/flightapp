package com.bluerbn.flightapp.repository.impl;

import com.bluerbn.flightapp.constants.Discount;
import com.bluerbn.flightapp.domain.Baggage;
import com.bluerbn.flightapp.domain.Coupon;
import com.bluerbn.flightapp.domain.Destination;
import com.bluerbn.flightapp.domain.Ticket;
import com.bluerbn.flightapp.repository.FlightRepository;
import com.bluerbn.flightapp.repository.FlightSequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Repository
public class FlightRepositoryImpl implements FlightRepository {

    private FlightSequenceGenerator sequence;

    private final List<Coupon> coupons = new ArrayList<>();

    private final List<Destination> destinations = new ArrayList<>();

    private final List<Baggage> baggages = new ArrayList<>();

    private final List<Ticket> tickets = new ArrayList<>();

    @Autowired
    public FlightRepositoryImpl(FlightSequenceGenerator sequence) {
        this.sequence = sequence;
    }

    @Override
    public Optional<Ticket> findTicket(Long ticketId) {
        return tickets.stream().filter(ticket -> ticket.getTicketId().equals(ticketId)).findFirst();
    }

    @Override
    public Optional<Coupon> findCoupon(Long couponId) {
        return coupons.stream().filter(coupon -> coupon.getCouponId().equals(couponId)).findFirst();
    }

    @Override
    public Optional<Destination> findDestination(Long destinationId) {
        return destinations.stream().filter(destination -> destination.getDestinationId().equals(destinationId)).findFirst();
    }

    @Override
    public Optional<Baggage> findBaggage(String baggageId) {
        return baggages.stream().filter(baggage -> baggage.getBaggageId().equalsIgnoreCase(baggageId)).findFirst();
    }

    @PostConstruct
    private void populateDataSource() {
        populateCoupons();
        populateDestinations();
        populateBaggages();
        populateTickets();
    }

    private void populateCoupons() {
        Arrays.stream(Discount.values())
                .forEach(discount -> coupons.add(new Coupon(sequence.nextLong(), discount.getAmountOff())));
    }

    private void populateDestinations() {
        IntStream.range(1, 10).forEach(index -> destinations.add(new Destination(sequence.nextLong())));
    }

    private void populateBaggages() {
        IntStream.range(1, 10).forEach(index -> baggages.add(new Baggage(sequence.nextStr())));
    }

    private void populateTickets() {
        IntStream.range(1, 10).forEach(index ->
                tickets.add(new Ticket(sequence.nextLong(),
                        destinations.stream().findAny().get(),
                        baggages.stream().findAny().get(),
                        sequence.ticketPrice()))
        );
    }


}

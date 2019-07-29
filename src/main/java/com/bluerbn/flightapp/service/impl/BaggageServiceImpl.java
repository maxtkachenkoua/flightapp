package com.bluerbn.flightapp.service.impl;

import com.bluerbn.flightapp.repository.FlightRepository;
import com.bluerbn.flightapp.service.BaggageService;
import org.springframework.stereotype.Service;

@Service
public class BaggageServiceImpl implements BaggageService {

    private final FlightRepository flightRepository;

    public BaggageServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public boolean checkIn(Long destinationId, String baggageId) {
        if (!flightRepository.findDestination(destinationId).isPresent()) {
            return false;
        }
        if (!flightRepository.findBaggage(baggageId).isPresent()) {
            return false;
        }
        return true;
    }
}

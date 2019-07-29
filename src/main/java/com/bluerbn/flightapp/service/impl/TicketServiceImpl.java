package com.bluerbn.flightapp.service.impl;

import com.bluerbn.flightapp.domain.Ticket;
import com.bluerbn.flightapp.repository.FlightRepository;
import com.bluerbn.flightapp.service.TicketService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.AbstractMap.SimpleEntry;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TicketServiceImpl implements TicketService {

    private Long cacheExpirationSeconds;

    private FlightRepository flightRepository;

    private final ConcurrentHashMap<Long, SimpleEntry<LocalDateTime, Ticket>> ticketCache = new ConcurrentHashMap<>();

    public TicketServiceImpl(FlightRepository flightRepository, @Value("${cache.expiration.seconds}") Long cacheExpirationSeconds) {
        this.flightRepository = flightRepository;
        this.cacheExpirationSeconds = cacheExpirationSeconds;
    }

    public boolean isTicketAvailable(Long ticketId) {
        SimpleEntry<LocalDateTime, Ticket> ticketEntry = ticketCache.get(ticketId);
        if (ticketEntry != null &&
                ChronoUnit.SECONDS.between(ticketEntry.getKey(), LocalDateTime.now()) < cacheExpirationSeconds) {
            return true;
        }

        Optional<Ticket> repositoryTicket = flightRepository.findTicket(ticketId);

        if (repositoryTicket.isPresent()) {
            ticketCache.put(ticketId, new SimpleEntry<>(LocalDateTime.now(), repositoryTicket.get()));
            return true;
        }
        return false;
    }
}

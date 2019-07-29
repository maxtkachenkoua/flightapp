package com.bluerbn.flightapp.repository;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@Component
public final class FlightSequenceGenerator {

    private final Random random = new Random();

    private AtomicLong longSequence = new AtomicLong(1);

    public long nextLong() {
        return longSequence.getAndIncrement();
    }

    public String nextStr() {
        return createLongToken();
    }

    public Double ticketPrice() {
        return Math.abs(random.nextDouble());
    }

    private String createLongToken() {
        byte[] buffer = new byte[24];
        random.nextBytes(buffer);
        return new String(Base64.encodeBase64URLSafe(buffer)).toUpperCase();
    }
}

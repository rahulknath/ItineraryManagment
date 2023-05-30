package com.nymble.tripbooking.Entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.nymble.tripbooking.Entitities.Passenger;
import com.nymble.tripbooking.Entitities.PassengerType;

public class PassengerTest {

    private Passenger passenger;

    @BeforeEach
    public void setUp() {
        passenger = new Passenger("John", PassengerType.GOLD, 1000.0);
    }

    @Test
    public void testGetName() {
        Assertions.assertEquals("John", passenger.getName());
    }

    @Test
    public void testGetPassengerType() {
        Assertions.assertEquals(PassengerType.GOLD, passenger.getPassengerType());
    }

    @Test
    public void testGetBalance() {
        Assertions.assertEquals(1000.0, passenger.getBalance());
    }

    @Test
    public void testGetPassengerNo() {
        Assertions.assertNotNull(passenger.getPassengerNo());
    }

    @Test
    public void testGetEnrolledActivities() {
        Assertions.assertNotNull(passenger.getEnrolledActivities());
    }
}

package com.nymble.tripbooking.Entities;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;

import org.junit.jupiter.api.Test;

import com.nymble.tripbooking.Entitities.Activity;
import com.nymble.tripbooking.Entitities.Destination;
import com.nymble.tripbooking.Entitities.Passenger;
import com.nymble.tripbooking.Entitities.PassengerType;
import com.nymble.tripbooking.Entitities.TravelPackage;
import com.nymble.tripbooking.services.IPassengerService;
import com.nymble.tripbooking.services.PassengerService;

public class ActivityTest {
   
    @Test
    public void testActivityRegistrationForPassenger() {
        Destination destination = new Destination("Beach");
        Activity activity = new Activity("Snorkeling", "Enjoy underwater marine life", 50.0, 20, destination);
        Passenger passenger = new Passenger("John", PassengerType.GOLD, 1000.0);
        IPassengerService passengerService = new PassengerService(
                new TravelPackage("Summer Vacation", 50, Collections.singletonList(destination)));
        passengerService.activityRegistration(passenger, activity);
        assertTrue(passenger.getEnrolledActivities().contains(activity));
    }
}

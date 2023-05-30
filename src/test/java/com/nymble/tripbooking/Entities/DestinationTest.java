package com.nymble.tripbooking.Entities;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.nymble.tripbooking.Entitities.Activity;
import com.nymble.tripbooking.Entitities.Destination;

public class DestinationTest {
    @Test
    public void testAddActivityToDestination() {
        Destination destination = new Destination("Beach");
        Activity activity = new Activity("Snorkeling", "Enjoy underwater marine life", 50.0, 20, destination);
        destination.addActivities(activity);
        assertTrue(destination.getActivities().contains(activity));
    }
}

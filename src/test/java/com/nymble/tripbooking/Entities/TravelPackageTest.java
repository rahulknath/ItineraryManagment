package com.nymble.tripbooking.Entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.nymble.tripbooking.Entitities.Activity;
import com.nymble.tripbooking.Entitities.Destination;
import com.nymble.tripbooking.Entitities.Passenger;
import com.nymble.tripbooking.Entitities.PassengerType;
import com.nymble.tripbooking.Entitities.TravelPackage;

import java.util.ArrayList;
import java.util.List;

public class TravelPackageTest {

    private TravelPackage travelPackage;

    @BeforeEach
    public void setUp() {
        // Create destinations
        Destination destination1 = new Destination("Beach");
        Destination destination2 = new Destination("Mountain");
        Destination destination3 = new Destination("City");
        Destination destination4 = new Destination("Island");
        Destination destination5 = new Destination("National Park");
        Destination destination6 = new Destination("Desert");

        // Create activities for destination1
        Activity activity1 = new Activity("Snorkeling", "Enjoy underwater marine life", 50.0, 20, destination1);
        Activity activity2 = new Activity("Sunbathing", "Relax and soak up the sun on the beach", 0.0, 100,
                destination1);
        destination1.addActivities(activity1);
        destination1.addActivities(activity2);

        // Create activities for destination2
        Activity activity3 = new Activity("Hiking", "Explore scenic trails in the mountains", 10.0, 30, destination2);
        Activity activity4 = new Activity("Skiing", "Hit the slopes and enjoy skiing", 80.0, 50, destination2);
        destination2.addActivities(activity3);
        destination2.addActivities(activity4);

        // Create activities for destination3
        Activity activity5 = new Activity("Sightseeing", "Explore famous landmarks", 20.0, 40, destination3);
        Activity activity6 = new Activity("Shopping", "Shop for souvenirs and local goods", 0.0, 80, destination3);
        destination3.addActivities(activity5);
        destination3.addActivities(activity6);

        // Create activities for destination4
        Activity activity7 = new Activity("trekking", "Discover beautiful forest and mountains", 30.0, 25,
                destination4);
        Activity activity8 = new Activity("Relaxing on the Beach", "Unwind and enjoy the pristine beaches", 0.0, 120,
                destination4);
        destination4.addActivities(activity7);
        destination4.addActivities(activity8);

        // Create activities for destination5
        Activity activity9 = new Activity("Hiking Trails", "Discover stunning natural landscapes", 15.0, 35,
                destination5);
        Activity activity10 = new Activity("Wildlife Safari", "Spot rare and exotic animals", 50.0, 60, destination5);
        destination5.addActivities(activity9);
        destination5.addActivities(activity10);

        // Create activities for destination6
        Activity activity11 = new Activity("Camel Riding", "Experience the traditional mode of transport", 25.0, 15,
                destination6);
        Activity activity12 = new Activity("Stargazing", "Marvel at the breathtaking night sky", 0.0, 90, destination6);
        destination6.addActivities(activity11);
        destination6.addActivities(activity12);

        // create travel package
        List<Destination> destinations = new ArrayList<>();
        destinations.add(destination1);
        destinations.add(destination2);
        destinations.add(destination3);
        destinations.add(destination4);
        destinations.add(destination5);
        destinations.add(destination6);
        travelPackage = new TravelPackage("Summer Vacation", 50, destinations);
    }


    @Test
    public void testGetPassengerCapacity() {
        Assertions.assertEquals(50, travelPackage.getPassengerCapacity());
    }

    @Test
    public void testGetPassengers() {
        List<Passenger> expectedPassengers = new ArrayList<>();
        expectedPassengers.add(new Passenger("John", PassengerType.GOLD, 1000.0));
        expectedPassengers.add(new Passenger("Jane", PassengerType.STANDARD, 500.0));
        expectedPassengers.add(new Passenger("Billy", PassengerType.PREMIUM));

        travelPackage.setPassengers(expectedPassengers);

        Assertions.assertEquals(expectedPassengers, travelPackage.getPassengers());
    }

    @Test
    public void testAddDestination() {
        Destination newDestination = new Destination("New Destination");
        travelPackage.getDestinations().add(newDestination);

        Assertions.assertTrue(travelPackage.getDestinations().contains(newDestination));
    }

    @Test
    public void testAddPassenger() {
        Passenger newPassenger = new Passenger("New Passenger", PassengerType.STANDARD, 1000.0);
        travelPackage.getPassengers().add(newPassenger);

        Assertions.assertTrue(travelPackage.getPassengers().contains(newPassenger));
    }

    @Test
    public void testRemoveDestination() {
        Destination destinationToRemove = travelPackage.getDestinations().get(0);
        travelPackage.getDestinations().remove(destinationToRemove);

        Assertions.assertFalse(travelPackage.getDestinations().contains(destinationToRemove));
    }
}
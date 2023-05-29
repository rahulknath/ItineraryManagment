/**
 * TripbookingApplicationTest is a test class that contains test cases for the TripbookingApplication class.
 * It tests various functionalities of the trip booking system.
 *
 * @author [Your Name]
 * @version 1.0
 * @since [Date or Version]
 */
package com.nymble.tripbooking;

import com.nymble.tripbooking.Entitities.Activity;
import com.nymble.tripbooking.Entitities.Destination;
import com.nymble.tripbooking.Entitities.Passenger;
import com.nymble.tripbooking.Entitities.PassengerType;
import com.nymble.tripbooking.Entitities.TravelPackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TripbookingApplicationTest {

    private TravelPackage travelPackage;
    private Passenger passenger1;
    private Passenger passenger2;

    @BeforeEach
    void setup() {
        // Create destinations
        Destination destination1 = new Destination("Beach", new ArrayList<>());
        Destination destination2 = new Destination("Mountain", new ArrayList<>());

        // Create activities for destination1
        Activity activity1 = new Activity(1, "Snorkeling", "Enjoy underwater marine life", 50.0, 20, destination1);
        Activity activity2 = new Activity(2, "Sunbathing", "Relax and soak up the sun on the beach", 0.0, 100, destination1);
        destination1.getActivities().add(activity1);
        destination1.getActivities().add(activity2);

        // Create activities for destination2
        Activity activity3 = new Activity(2, "Hiking", "Explore scenic trails in the mountains", 10.0, 30, destination2);
        Activity activity4 = new Activity(4, "Skiing", "Hit the slopes and enjoy skiing", 80.0, 50, destination2);
        destination2.getActivities().add(activity3);
        destination2.getActivities().add(activity4);

        // Create passengers
        passenger1 = new Passenger("John", 1, 1000.0, PassengerType.GOLD, new ArrayList<>());
        passenger2 = new Passenger("Jane", 2, 500.0, PassengerType.STANDARD, new ArrayList<>());

        // Enroll activities for passengers
        passenger1.getEnrolledActivities().add(activity1);
        passenger1.getEnrolledActivities().add(activity3);
        passenger2.getEnrolledActivities().add(activity2);
        passenger2.getEnrolledActivities().add(activity4);

        // Create a travel package
        List<Destination> destinations = new ArrayList<>();
        destinations.add(destination1);
        destinations.add(destination2);

        List<Passenger> passengers = new ArrayList<>();
        passengers.add(passenger1);
        passengers.add(passenger2);

        travelPackage = new TravelPackage("Summer Vacation", 50, destinations, passengers);
    }

    @Test
    void testPrintItinerary() {
        // Test that the itinerary is printed correctly
        travelPackage.printItinerary();

        // No assertions as this is a print statement
    }

    @Test
    void testPrintPassengerList() {
        // Test that the passenger list is printed correctly
        travelPackage.printPassengerList();

        // No assertions as this is a print statement
    }

    @Test
    void testPrintAvailableActivities() {
        // Test that the available activities are printed correctly
        travelPackage.printAvailableActivities();

        // No assertions as this is a print statement
    }

    @Test
    void testPrintPassengerDetails() {
        // Test that the passenger details are printed correctly for passenger1
        passenger1.printPassengersDetails();

        // No assertions as this is a print statement

        // Test that the passenger details are printed correctly for passenger2
        passenger2.printPassengersDetails();

        // No assertions as this is a print statement
    }

    // @Test
    // void testEnrollActivities() {
    //     // Verify that passenger1 is enrolled in activity1
    //     Assertions.assertTrue(passenger1.getEnrolledActivities().contains(travelPackage.getDestinations().get(0).getActivities().get(0)));

    //     // Verify that passenger1 is enrolled in activity3
    //     Assertions.assertTrue(passenger1.getEnrolledActivities().contains(travelPackage.getDestinations().get(1).getActivities().get(0)));

    //     // Verify that passenger2 is enrolled in activity2
    //     Assertions.assertTrue(passenger2.getEnrolledActivities().contains(travelPackage.getDestinations().get(0).getActivities().get(1)));

    //     // Verify that passenger2 is enrolled in activity4
    //     Assertions.assertTrue(passenger2.getEnrolledActivities().contains(travelPackage.getDestinations().get(1).getActivities().get(1)));
    // }
}

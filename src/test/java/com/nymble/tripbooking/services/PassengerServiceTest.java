package com.nymble.tripbooking.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.nymble.tripbooking.Entitities.Activity;
import com.nymble.tripbooking.Entitities.Destination;
import com.nymble.tripbooking.Entitities.Passenger;
import com.nymble.tripbooking.Entitities.PassengerType;
import com.nymble.tripbooking.Entitities.TravelPackage;

public class PassengerServiceTest {

    private IPassengerService passengerService;
    private ITravelPackageService travelPackageService;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @BeforeEach
    void init() {
        // Create destinations
        Destination destination1 = new Destination("Beach");

        // Create activities for destination1
        Activity activity1 = new Activity("Snorkeling", "Enjoy underwater marine life", 50.0, 20, destination1);
        Activity activity2 = new Activity("Sunbathing", "Relax and soak up the sun on the beach", 0.0, 100,
                destination1);
        destination1.addActivities(activity1);
        destination1.addActivities(activity2);

        // create travel package
        List<Destination> destinations = new ArrayList<>();
        destinations.add(destination1);

        TravelPackage package1 = new TravelPackage("Summer Vacation", 50, destinations);

        // Create passengers
        Passenger passenger1 = new Passenger("John", PassengerType.GOLD, 1000.0);

        // Enroll activities for passengers
        passengerService = new PassengerService(package1);

        passengerService.activityRegistration(passenger1, activity1);
        passengerService.activityRegistration(passenger1, activity2);

        travelPackageService = new TravelPackageService(package1);
    }

    @DisplayName("Unit Test for passenger Details")
    @Test
    void testingPassengersDetails() {
        
         // Create destinations
        Destination destination1 = new Destination("Beach");

        // Create activities for destination1
        Activity activity1 = new Activity("Snorkeling", "Enjoy underwater marine life", 50.0, 20, destination1);
        Activity activity2 = new Activity("Sunbathing", "Relax and soak up the sun on the beach", 0.0, 100,
                destination1);
        destination1.addActivities(activity1);
        destination1.addActivities(activity2);

        // create travel package
        List<Destination> destinations = new ArrayList<>();
        destinations.add(destination1);

        TravelPackage package1 = new TravelPackage("Summer Vacation", 50, destinations);

        // Create passengers
        Passenger passenger1 = new Passenger("John",PassengerType.GOLD,1000.0,"A1");

        // Enroll activities for passengers
        passengerService = new PassengerService(package1);

        passengerService.activityRegistration(passenger1, activity1);
        passengerService.activityRegistration(passenger1, activity2);

        travelPackageService = new TravelPackageService(package1);

        
        System.out.print(passengerService.printPassengersDetails(passenger1));
    String expectedOutput = "Passenger Name: John\n" +
                            "Passenger Number: A1\n" +
                            "Balance: 995.0\n" +
                            "Activities Signed Up:\n" +
                            "- Destination: Beach, Activity: Snorkeling, Price paid: 45.0\n" +
                            "- Destination: Beach, Activity: Sunbathing, Price paid: 0.0\n";
    assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
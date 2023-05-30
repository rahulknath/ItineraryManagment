package com.nymble.tripbooking.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.nymble.tripbooking.Entitities.Activity;
import com.nymble.tripbooking.Entitities.Destination;
import com.nymble.tripbooking.Entitities.Passenger;
import com.nymble.tripbooking.Entitities.PassengerType;
import com.nymble.tripbooking.Entitities.TravelPackage;

public class TravelPackageServiceTest{
    private IPassengerService passengerService;
    private ITravelPackageService travelPackageService;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @DisplayName("Unit Test for itinerary")
    @Test
    void testingPrintItinerary() {
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

          System.out.print(travelPackageService.printItinerary());



          String expectedOutput = "Travel Package: Summer Vacation\nDestinations :\n"+
          "- Snorkeling (Cost: 50.0) (Capacity: 20) (Description: Enjoy underwater marine life)\n"+
          "- Sunbathing (Cost: 0.0) (Capacity: 100) (Description: Relax and soak up the sun on the beach)\n";
          assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @DisplayName("Unit Test for passenger Details")
    @Test
    void testingPrintPassengerList() {
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

        System.out.print(travelPackageService.printPassengerList());



        String expectedOutput = "Travel Package: Summer Vacation\n"
        +"Passenger Capacity: 50\n"
        +"Number of Passengers Enrolled: 1\n"
        +"Passengers:\n"
        +"- John (Number: A1)\n";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @DisplayName("Unit Test for available activities")
    @Test
    void testingprintAvailableActivities() {
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
        
                System.out.print(travelPackageService.printAvailableActivities());
        
        
        
                String expectedOutput = "- Destination: Beach, Activity: Snorkeling, Available Spaces: 19\n"+
                "- Destination: Beach, Activity: Sunbathing, Available Spaces: 99\n";
                assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
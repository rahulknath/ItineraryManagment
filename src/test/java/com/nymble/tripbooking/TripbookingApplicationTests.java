package com.nymble.tripbooking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

// import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.nymble.tripbooking.Entitities.Activity;
import com.nymble.tripbooking.Entitities.Destination;
import com.nymble.tripbooking.Entitities.Passenger;
import com.nymble.tripbooking.Entitities.PassengerType;
import com.nymble.tripbooking.Entitities.TravelPackage;

// class TripbookingApplicationTests {

// 	private TravelPackage travelPackage;

//     @BeforeEach
//     public void setUp() {
//         Destination destination1 = new Destination(1, "Beach", Arrays.asList(
//                 new Activity(1, "Sunbathing", "Enjoy the sun and relax on the beach.", 10.0, 50, null),
//                 new Activity(2, "Snorkeling", "Explore the underwater world with snorkeling.", 20.0, 30, null)
//         ));
//         Destination destination2 = new Destination(2, "Mountain", Arrays.asList(
//                 new Activity(3, "Hiking", "Experience the thrill of hiking in the mountains.", 15.0, 40, null),
//                 new Activity(4, "Camping", "Enjoy camping amidst the scenic beauty of the mountains.", 25.0, 20, null)
//         ));

//         Passenger passenger1 = new Passenger("Bob", 1, 100.0, PassengerType.STANDARD,
//                 Arrays.asList(destination1.getActivities().get(0), destination2.getActivities().get(1)));
//         Passenger passenger2 = new Passenger("Alice", 2, 200.0, PassengerType.GOLD,
//                 Arrays.asList(destination1.getActivities().get(1), destination2.getActivities().get(0)));

//         travelPackage = new TravelPackage(1, "Summer Vacation", 100,
//                 Arrays.asList(destination1, destination2), Arrays.asList(passenger1, passenger2));
//     }

//     @Test
//     public void testPrintItinerary() {
//         String expectedOutput = "Travel Package Name :Summer Vacation\n" +
//                 "Destinations :\n" +
//                 "1. Beach\n" +
//                 "Activities :\n" +
//                 "1. Name: Sunbathing\n" +
//                 "  Cost: 10.0\n" +
//                 "  Capacity: 50\n" +
//                 "  Description: Enjoy the sun and relax on the beach.\n" +
//                 "2. Name: Snorkeling\n" +
//                 "  Cost: 20.0\n" +
//                 "  Capacity: 30\n" +
//                 "  Description: Explore the underwater world with snorkeling.\n" +
//                 "Destinations :\n" +
//                 "2. Mountain\n" +
//                 "Activities :\n" +
//                 "3. Name: Hiking\n" +
//                 "  Cost: 15.0\n" +
//                 "  Capacity: 40\n" +
//                 "  Description: Experience the thrill of hiking in the mountains.\n" +
//                 "4. Name: Camping\n" +
//                 "  Cost: 25.0\n" +
//                 "  Capacity: 20\n" +
//                 "  Description: Enjoy camping amidst the scenic beauty of the mountains.\n";

//         assertEquals(expectedOutput, captureOutput(() -> travelPackage.printItinerary()));
//     }

//     @Test
//     public void testPrintEnrolledPassengers() {
//         String expectedOutput = "Package Name: Summer Vacation\n" +
//                 "Passenger Capacity: 100\n" +
//                 "No of Passengers Enrolled: 2\n" +
//                 "Passenger Details: \n" +
//                 "1. Name: Bob Number: 1\n" +
//                 "2. Name: Alice Number: 2\n";

//         assertEquals(expectedOutput, captureOutput(() -> travelPackage.printEnrolledPassengers()));
//     }

//     @Test
//     public void testPrintActivityDetails() {
//         String expectedOutput = "Details of Activities: \n" +
//                 "1. Name: Sunbathing\n" +
//                 "  Cost: 10.0\n" +
//                 "  Capacity: 50\n" +
//                 "  Description: Enjoy the sun and relax on the beach.\n" +
//                 "  Available Capacity: 49\n" +
//                 "2. Name: Snorkeling\n" +
//                 "  Cost: 20.0\n" +
//                 "  Capacity: 30\n" +
//                 "  Description: Explore the underwater world with snorkeling.\n" +
//                 "  Available Capacity: 29\n" +
//                 "3. Name: Hiking\n" +
//                 "  Cost: 15.0\n" +
//                 "  Capacity: 40\n" +
//                 "  Description: Experience the thrill of hiking in the mountains.\n" +
//                 "  Available Capacity: 39\n" +
//                 "4. Name: Camping\n" +
//                 "  Cost: 25.0\n" +
//                 "  Capacity: 20\n" +
//                 "  Description: Enjoy camping amidst the scenic beauty of the mountains.\n" +
//                 "  Available Capacity: 19\n";

//         assertEquals(expectedOutput, captureOutput(() -> travelPackage.printActivityDetails()));
//     }

//     @Test
//     public void testGetPricePaid_StandardPassenger() {
//         Passenger passenger = new Passenger("John", 3, 100.0, PassengerType.STANDARD, null);
//         Double expectedPrice = 10.0; // Standard passenger pays the full cost

//         assertEquals(expectedPrice, passenger.getPricePaid(10.0));
//     }

//     @Test
//     public void testGetPricePaid_GoldPassenger() {
//         Passenger passenger = new Passenger("Jane", 4, 200.0, PassengerType.GOLD, null);
//         Double expectedPrice = 2.0; // Gold passenger pays 10% of the cost

//         assertEquals(expectedPrice, passenger.getPricePaid(20.0));
//     }

//     @Test
//     public void testGetPricePaid_PremiumPassenger() {
//         Passenger passenger = new Passenger("Mike", 5, 300.0, PassengerType.PREMIUM, null);
//         Double expectedPrice = 0.0; // Premium passenger doesn't pay for activities

//         assertEquals(expectedPrice, passenger.getPricePaid(30.0));
//     }

//     // Helper method to capture the console output
//     private String captureOutput(Runnable code) {
//         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//         PrintStream printStream = new PrintStream(outputStream);
//         PrintStream originalOut = System.out;
//         System.setOut(printStream);

//         code.run();

//         System.out.flush();
//         System.setOut(originalOut);
//         return outputStream.toString();
//     }

// }

public class TripbookingApplicationTests {

    @Test
    public void testPrintItinerary() {
        // Create sample destinations and activities
        Destination destination1 = new Destination(1, "Destination 1", Arrays.asList(
                new Activity(1, "Activity 1", "Description 1", 100.0, 10, null),
                new Activity(2, "Activity 2", "Description 2", 150.0, 5, null)
        ));
        Destination destination2 = new Destination(2, "Destination 2", Arrays.asList(
                new Activity(3, "Activity 3", "Description 3", 200.0, 8, null),
                new Activity(4, "Activity 4", "Description 4", 120.0, 12, null)
        ));

        // Create a travel package with the above destinations
        List<Destination> destinations = Arrays.asList(destination1, destination2);
        TravelPackage travelPackage = new TravelPackage(1, "Package 1", 20, destinations, null);

        // Capture the output of printItinerary()
        ByteArrayOutputStream outputStream = captureOutput();
        travelPackage.printItinerary();
        String output = outputStream.toString().trim();

        // Verify the output
        String expectedOutput = "Travel Package Name :Package 1\n" +
                "Destinations :\n" +
                "1. Destination 1\n" +
                "Activities :\n" +
                "1. Name: Activity 1\n" +
                "   Cost: 100.0\n" +
                "   Capacity: 10\n" +
                "   Description: Description 1\n" +
                "2. Name: Activity 2\n" +
                "   Cost: 150.0\n" +
                "   Capacity: 5\n" +
                "   Description: Description 2\n" +
                "Destinations :\n" +
                "2. Destination 2\n" +
                "Activities :\n" +
                "3. Name: Activity 3\n" +
                "   Cost: 200.0\n" +
                "   Capacity: 8\n" +
                "   Description: Description 3\n" +
                "4. Name: Activity 4\n" +
                "   Cost: 120.0\n" +
                "   Capacity: 12\n" +
                "   Description: Description 4";
        assertEquals(expectedOutput, output);
    }

    @Test
    public void testPrintEnrolledPassengers() {
        // Create sample passengers
        Passenger passenger1 = new Passenger("John", 1, 1000.0, PassengerType.GOLD, null);
        Passenger passenger2 = new Passenger("Jane", 2, 500.0, PassengerType.STANDARD, null);
        Passenger passenger3 = new Passenger("Mark", 3, 0.0, PassengerType.PREMIUM, null);

        // Create a travel package with the above passengers
        List<Passenger> passengers = Arrays.asList(passenger1, passenger2, passenger3);
        TravelPackage travelPackage = new TravelPackage(1, "Package 1", 20, null, passengers);

        // Capture the output of printEnrolledPassengers()
        ByteArrayOutputStream outputStream = captureOutput();
        travelPackage.printPassengerList();
        String output = outputStream.toString().trim();

        // Verify the output
        String expectedOutput = "Package Name: Package 1\n" +
                "Passenger Capacity: 20\n" +
                "No of Passengers Enrolled: 3\n" +
                "Passenger Details: \n" +
                "1. Name: John Number: 1\n" +
                "2. Name: Jane Number: 2\n" +
                "3. Name: Mark Number: 3";
        assertEquals(expectedOutput, output);
    }

    @Test
    public void testPrintActivityDetails() {
        // Create sample destinations, activities, and passengers
        Destination destination1 = new Destination(1, "Destination 1", Arrays.asList(
                new Activity(1, "Activity 1", "Description 1", 100.0, 10, null),
                new Activity(2, "Activity 2", "Description 2", 150.0, 5, null)
        ));
        Destination destination2 = new Destination(2, "Destination 2", Arrays.asList(
                new Activity(3, "Activity 3", "Description 3", 200.0, 8, null),
                new Activity(4, "Activity 4", "Description 4", 120.0, 12, null)
        ));

        Passenger passenger1 = new Passenger("John", 1, 1000.0, PassengerType.GOLD, Arrays.asList(
                new Activity(1, "Activity 1", "Description 1", 100.0, 10, destination1),
                new Activity(3, "Activity 3", "Description 3", 200.0, 8, destination2)
        ));
        Passenger passenger2 = new Passenger("Jane", 2, 500.0, PassengerType.STANDARD, Arrays.asList(
                new Activity(2, "Activity 2", "Description 2", 150.0, 5, destination1),
                new Activity(3, "Activity 3", "Description 3", 200.0, 8, destination2)
        ));
        Passenger passenger3 = new Passenger("Mark", 3, 0.0, PassengerType.PREMIUM, Arrays.asList(
                new Activity(1, "Activity 1", "Description 1", 100.0, 10, destination1),
                new Activity(4, "Activity 4", "Description 4", 120.0, 12, destination2)
        ));

        // Create a travel package with the above destinations and passengers
        List<Destination> destinations = Arrays.asList(destination1, destination2);
        List<Passenger> passengers = Arrays.asList(passenger1, passenger2, passenger3);
        TravelPackage travelPackage = new TravelPackage(1, "Package 1", 20, destinations, passengers);

        // Capture the output of printActivityDetails()
        ByteArrayOutputStream outputStream = captureOutput();
        travelPackage.printAvailableActivities();
        String output = outputStream.toString().trim();

        // Verify the output
        String expectedOutput = "Details of Activities: \n" +
                "1. Name: Activity 1\n" +
                "   Cost: 100.0\n" +
                "   Capacity: 10\n" +
                "   Description: Description 1\n" +
                "   Available Capacity: 8\n" +
                "2. Name: Activity 2\n" +
                "   Cost: 150.0\n" +
                "   Capacity: 5\n" +
                "   Description: Description 2\n" +
                "   Available Capacity: 4\n" +
                "3. Name: Activity 3\n" +
                "   Cost: 200.0\n" +
                "   Capacity: 8\n" +
                "   Description: Description 3\n" +
                "   Available Capacity: 5\n" +
                "4. Name: Activity 4\n" +
                "   Cost: 120.0\n" +
                "   Capacity: 12\n" +
                "   Description: Description 4\n" +
                "   Available Capacity: 11";
        assertEquals(expectedOutput, output);
    }

    // Helper method to capture the output of System.out.println()
    private ByteArrayOutputStream captureOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        return outputStream;
    }
}

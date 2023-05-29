// package com.nymble.tripbooking;

// import com.nymble.tripbooking.Entitities.Activity;
// import com.nymble.tripbooking.Entitities.Destination;
// import com.nymble.tripbooking.Entitities.Passenger;
// import com.nymble.tripbooking.Entitities.PassengerType;
// import com.nymble.tripbooking.Entitities.TravelPackage;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import java.util.ArrayList;
// import java.util.List;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// public class TravelPackageTest {
//     private TravelPackage travelPackage;
//     private Destination destination1;
//     private Destination destination2;
//     private Activity activity1;
//     private Activity activity2;
//     private Activity activity3;
//     private Activity activity4;
//     private Passenger passenger1;
//     private Passenger passenger2;

//     @BeforeEach
//     public void setUp() {
//         // Create destinations
//         destination1 = new Destination("Beach", new ArrayList<>());
//         destination2 = new Destination("Mountain", new ArrayList<>());

//         // Create activities for destination1
//         activity1 = new Activity(1, "Snorkeling", "Enjoy underwater marine life", 50.0, 20, destination1);
//         activity2 = new Activity(2, "Sunbathing", "Relax and soak up the sun on the beach", 0.0, 100, destination1);
//         destination1.getActivities().add(activity1);
//         destination1.getActivities().add(activity2);

//         // Create activities for destination2
//         activity3 = new Activity(2, "Hiking", "Explore scenic trails in the mountains", 10.0, 30, destination2);
//         activity4 = new Activity(4, "Skiing", "Hit the slopes and enjoy skiing", 80.0, 50, destination2);
//         destination2.getActivities().add(activity3);
//         destination2.getActivities().add(activity4);

//         // Create passengers
//         passenger1 = new Passenger("John", 1, 1000.0, PassengerType.GOLD, new ArrayList<>());
//         passenger2 = new Passenger("Jane", 2, 500.0, PassengerType.STANDARD, new ArrayList<>());

//         // Enroll activities for passengers
//         passenger1.getEnrolledActivities().add(activity1);
//         passenger1.getEnrolledActivities().add(activity3);
//         passenger2.getEnrolledActivities().add(activity2);
//         passenger2.getEnrolledActivities().add(activity4);

//         // Create a travel package
//         List<Destination> destinations = new ArrayList<>();
//         destinations.add(destination1);
//         destinations.add(destination2);

//         List<Passenger> passengers = new ArrayList<>();
//         passengers.add(passenger1);
//         passengers.add(passenger2);

//         travelPackage = new TravelPackage("Summer Vacation", 50, destinations, passengers);
//     }

//     @Test
//     public void testPrintItinerary() {
//         // Expected output
//         String expected = "Travel Package: Summer Vacation\n" +
//                 "Destinations :\n" +
//                 "Beach\n" +
//                 "- Snorkeling (Cost: 50.0) (Capacity: 20) (Description: Enjoy underwater marine life)\n" +
//                 "- Sunbathing (Cost: 0.0) (Capacity: 100) (Description: Relax and soak up the sun on the beach)\n" +
//                 "Mountain\n" +
//                 "- Hiking (Cost: 10.0) (Capacity: 30) (Description: Explore scenic trails in the mountains)\n" +
//                 "- Skiing (Cost: 80.0) (Capacity: 50) (Description: Hit the slopes and enjoy skiing)\n";

//         // Perform the test
//         String actual = travelPackage.printItinerary();

//         // Check the result
//         assertEquals(expected, actual);
//     }

//     @Test
//     public void testPrintPassengerList() {
//         // Expected output
//         String expected = "Enrolled Passengers:\n" +
//                 "1. John (Gold)\n" +
//                 "   - Snorkeling\n" +
//                 "   - Hiking\n" +
//                 "2. Jane (Standard)\n" +
//                 "   - Sunbathing\n" +
//                 "   - Skiing\n";

//         // Perform the test
//         String actual = travelPackage.getPassengerList();

//         // Check the result
//         assertEquals(expected, actual);
//     }

//     @Test
//     public void testPrintAvailableActivities() {
//         // Expected output
//         String expected = "Available Activities:\n" +
//                 "Beach\n" +
//                 "- Snorkeling (Cost: 50.0) (Capacity: 20) (Description: Enjoy underwater marine life)\n" +
//                 "- Sunbathing (Cost: 0.0) (Capacity: 100) (Description: Relax and soak up the sun on the beach)\n" +
//                 "Mountain\n" +
//                 "- Hiking (Cost: 10.0) (Capacity: 30) (Description: Explore scenic trails in the mountains)\n" +
//                 "- Skiing (Cost: 80.0) (Capacity: 50) (Description: Hit the slopes and enjoy skiing)\n";

//         // Perform the test
//         String actual = travelPackage.getAvailableActivities();

//         // Check the result
//         assertEquals(expected, actual);
//     }
// }

/**
 * TripbookingApplication is a class that demonstrates the functionality of the trip booking system.
 * It creates destinations, activities, passengers, and a travel package, and performs various operations such as enrolling activities,
 * printing itinerary, passenger list, available activities, and passenger details.
 *
 * @author Rahul Kumar Nath
 * @version 1.0
 * @since 26-05-2023
 */
package com.nymble.tripbooking;

import java.util.ArrayList;
import java.util.List;

import com.nymble.tripbooking.Entitities.Activity;
import com.nymble.tripbooking.Entitities.Destination;
import com.nymble.tripbooking.Entitities.Passenger;
import com.nymble.tripbooking.Entitities.PassengerType;
import com.nymble.tripbooking.Entitities.TravelPackage;

public class TripbookingApplication {

	public static void main(String[] args) {
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
		 Passenger passenger1 = new Passenger("John", 1, 1000.0, PassengerType.GOLD, new ArrayList<>());
		 Passenger passenger2 = new Passenger("Jane", 2, 500.0, PassengerType.STANDARD, new ArrayList<>());
 
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
 
		 TravelPackage travelPackage = new TravelPackage("Summer Vacation", 50, destinations, passengers);
 
		 // Print itinerary
		 travelPackage.printItinerary();
 
		 System.out.println();
 
		 // Print enrolled passengers
		 travelPackage.printPassengerList();
 
		 System.out.println();
 
		 // Print activity details
		 travelPackage.printAvailableActivities();
 
		 System.out.println();
 
		 // Print passenger details
		 passenger1.printPassengersDetails();
		 System.out.println();
		 passenger2.printPassengersDetails();
	}

}

package com.nymble.tripbooking.services;

import com.nymble.tripbooking.Entitities.Activity;
import com.nymble.tripbooking.Entitities.Destination;
import com.nymble.tripbooking.Entitities.Passenger;
import com.nymble.tripbooking.Entitities.TravelPackage;

/**
 * The TravelPackageService class provides operations related to travel package services.
 */
public class TravelPackageService implements ITravelPackageService {

    private TravelPackage travelPackage;

    /**
     * Constructs a TravelPackageService object with the specified travel package.
     *
     * @param travelPackage the travel package
     */
    public TravelPackageService(TravelPackage travelPackage) {
        this.travelPackage = travelPackage;
    }

    /**
     * Prints the itinerary of the travel package, including destinations and their activities.
     */
    @Override
    public String printItinerary() {
        StringBuilder output = new StringBuilder();
        output.append("Travel Package: " + travelPackage.getName() + "\n");
        output.append("Destinations :\n");
        for (Destination destination : travelPackage.getDestinations()) {
            for (Activity activity : destination.getActivities()) {
                output.append("- " + activity.getName() + " (Cost: " + activity.getCost() + ")" +
                " (Capacity: " + activity.getCapacity() + ")" +
                " (Description: " + activity.getDescription() + ")").append("\n");
            }
        }
        return output.toString();
    }

    /**
     * Prints the list of passengers enrolled in the travel package.
     */
    @Override
    public String printPassengerList() {
        StringBuilder output = new StringBuilder();
        output.append("Travel Package: " + travelPackage.getName()).append("\n");
        output.append("Passenger Capacity: " + travelPackage.getPassengerCapacity()).append("\n");
        output.append("Number of Passengers Enrolled: " + travelPackage.getPassengers().size()).append("\n");
        output.append("Passengers:").append("\n");
        for (Passenger passenger : travelPackage.getPassengers()) {
            output.append("- " + passenger.getName() + " (Number: " + passenger.getPassengerNo() + ")").append("\n");
        }
        return output.toString();
    }

    /**
     * Prints the details of available activities in the travel package.
     */
    @Override
    public String printAvailableActivities() {
        StringBuilder output = new StringBuilder();
        for (Destination destination : travelPackage.getDestinations()) {
            for (Activity activity : destination.getActivities()) {
                if (activity.getNumberOfAvialableCapacity() > 0) {
                    output.append("- Destination: " + activity.getDestination().getName() + ", Activity: "
                            + activity.getName() + ", Available Spaces: " + activity.getNumberOfAvialableCapacity()).append("\n");
                }
            }
        }
        return output.toString();
    }

}

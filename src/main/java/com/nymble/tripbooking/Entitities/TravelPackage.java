/**

The TravelPackage class represents a travel package that includes multiple destinations and passengers.
*/
package com.nymble.tripbooking.Entitities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TravelPackage {
    private String Id;
    private String name;
    private Integer passengerCapacity;
    private List<Destination> destinations;
    private List<Passenger> passengers;

    /**
     * Constructs a TravelPackage object with the specified parameters.
     *
     * @param name              the name of the travel package
     * @param passengerCapacity the maximum capacity of passengers for the travel
     *                          package
     * @param destinations      the list of destinations included in the travel
     *                          package
     * @param passengers        the list of passengers enrolled in the travel
     *                          package
     */
    public TravelPackage(String name, Integer passengerCapacity, List<Destination> destinations,
            List<Passenger> passengers) {
        this.Id = UUID.randomUUID().toString().substring(0, 3);
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.destinations = destinations;
        this.passengers = passengers;
    }

    /**
     * Prints the itinerary of the travel package, including destinations and their
     * activities.
     */
    public void printItinerary() {
        System.out.println("Travel Package: " + this.name);
        System.out.println("Destinations :");
        for (Destination destination : destinations) {
            System.out.println(destination.getName());
            for (Activity activity : destination.getActivities()) {
                System.out.println("- " + activity.getName() + " (Cost: " + activity.getCost() + ")" +
                        " (Capacity: " + activity.getCapacity() + ")" +
                        " (Description: " + activity.getDescription() + ")");
            }
        }
    }

    /**
     * Prints the list of passengers enrolled in the travel package.
     */
    public void printPassengerList() {
        System.out.println("Travel Package: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers Enrolled: " + passengers.size());
        System.out.println("Passengers:");
        for (Passenger passenger : passengers) {
            System.out.println("- " + passenger.getName() + " (Number: " + passenger.getPassengerNo() + ")");
        }
    }

    /**
     * Prints the details of available activities in the travel package.
     */
    public void printAvailableActivities() {
        System.out.println("Details of Activities: ");
        Map<Activity, Integer> mActivities = new HashMap<>();
        for (Passenger passenger : passengers) {
            List<Activity> lAct = passenger.getEnrolledActivities();
            for (Activity activity : lAct) {
                if (mActivities.containsKey(activity)) {
                    mActivities.put(activity, mActivities.get(activity) + 1);
                } else {
                    mActivities.put(activity, 1);
                }
            }
        }

        for (Map.Entry<Activity, Integer> mEntry : mActivities.entrySet()) {
            mActivities.put(mEntry.getKey(), mEntry.getKey().getCapacity() - mEntry.getValue());
        }

        for (Map.Entry<Activity, Integer> mEntry : mActivities.entrySet()) {
            Activity activity = mEntry.getKey();

            System.out.println("- Destination: " + activity.getDestination().getName() + ", Activity: "
                    + activity.getName() + ", Available Spaces: " + mEntry.getValue());

        }
    }

}
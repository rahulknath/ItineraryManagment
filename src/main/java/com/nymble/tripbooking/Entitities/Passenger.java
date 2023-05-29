/**
The Passenger class represents a passenger enrolled in a travel package.
*/

package com.nymble.tripbooking.Entitities;

import java.util.List;
import java.util.UUID;

public class Passenger {
    private String name;
    private String passengerNo;
    private Double balance;
    private PassengerType passengerType;
    private List<Activity> enrolledActivities;

    /**
     * Constructs a Passenger object with the specified parameters.
     *
     * @param name               the name of the passenger
     * @param passengerNo        the passenger number
     * @param balance            the balance of the passenger
     * @param passengerType      the type of the passenger (STANDARD, GOLD, or
     *                           PREMIUM)
     * @param enrolledActivities the list of activities in which the passenger is
     *                           enrolled
     */
    public Passenger(String name, Integer passengerNo, Double balance, PassengerType passengerType,
            List<Activity> enrolledActivities) {
        this.name = name;
        this.passengerNo = UUID.randomUUID().toString().substring(0, 3);
        this.balance = balance;
        this.passengerType = passengerType;
        this.enrolledActivities = enrolledActivities;
    }

    /**
     * Returns the name of the passenger.
     *
     * @return the name of the passenger
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the passenger number.
     *
     * @return the passenger number
     */
    public String getPassengerNo() {
        return passengerNo;
    }

    /**
     * Returns the balance of the passenger.
     *
     * @return the balance of the passenger
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * Returns the type of the passenger.
     *
     * @return the passenger type (STANDARD, GOLD, or PREMIUM)
     */
    public PassengerType getPassengerType() {
        return passengerType;
    }

    /**
     * Returns the list of activities in which the passenger is enrolled.
     *
     * @return the list of enrolled activities
     */
    public List<Activity> getEnrolledActivities() {
        return enrolledActivities;
    }

    /**
     * Prints the details of the passenger, including name, number, and enrolled
     * activities.
     */
    public void printPassengersDetails() {
        System.out.println("Passenger Name: " + this.getName());
        System.out.println("Passenger Number: " + this.getPassengerNo());
        if (passengerType.equals(PassengerType.GOLD) || passengerType.equals(PassengerType.STANDARD)) {
            System.out.println("Balance: " + getBalance());
        }
        System.out.println("Activities Signed Up:");
        for (Activity activity : enrolledActivities) {
            System.out.println("- Destination: " + activity.getDestination().getName() + ", Activity: "
                    + activity.getName() + ", Price: " + getPricePaid(activity.getCost()));
        }
    }

    /**
     * Calculates and returns the price paid by the passenger for a given activity.
     *
     * @param cost the cost of the activity
     * @return the price paid by the passenger
     */
    public Double getPricePaid(Double cost) {
        if (passengerType.equals(PassengerType.GOLD)) {
            return cost * 0.1;
        } else if (passengerType.equals(PassengerType.STANDARD)) {
            return cost;
        } else {
            return 0.0;
        }
    }

}

/**
 * The Passenger class represents a passenger enrolled in a travel package.
 */
package com.nymble.tripbooking.Entitities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Passenger {
    private String name;
    private String passengerNo;
    private Double balance;
    private PassengerType passengerType;
    private List<Activity> enrolledActivities;

    public Passenger(String name, PassengerType passengerType,Double balance, String passengerNo) {
        this.name = name;
        this.passengerNo = passengerNo;
        this.balance = balance;
        this.passengerType = passengerType;
        this.enrolledActivities =  new ArrayList<>();
    }

    /**
     * Constructs a Passenger object with the specified name and passenger type.
     *
     * @param name          the name of the passenger
     * @param passengerType the type of the passenger (STANDARD, GOLD, or PREMIUM)
     */
    public Passenger(String name, PassengerType passengerType) {
        this.name = name;
        this.passengerNo = UUID.randomUUID().toString().substring(0, 3);
        this.passengerType = passengerType;
        this.enrolledActivities = new ArrayList<>();
        this.balance = 0.0;
    }

    /**
     * Constructs a Passenger object with the specified name, passenger type, and balance.
     *
     * @param name          the name of the passenger
     * @param passengerType the type of the passenger (STANDARD, GOLD, or PREMIUM)
     * @param balance       the balance of the passenger
     */
    public Passenger(String name, PassengerType passengerType, double balance) {
        this(name, passengerType);
        this.balance = balance;
    }

    public Passenger(String name, PassengerType premium, String id,double balance) {
        this.name = name;
        this.passengerType = premium;
        this.passengerNo = id;
        this.balance = balance;
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
     * Sets the balance of the passenger.
     *
     * @param balance the balance of the passenger
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setPassengerNo(String string) {
    }
}

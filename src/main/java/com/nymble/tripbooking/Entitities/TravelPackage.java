/**
 * The TravelPackage class represents a travel package that includes multiple destinations and passengers.
 */
package com.nymble.tripbooking.Entitities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TravelPackage {
    private String Id;
    private String name;
    private Integer passengerCapacity;
    private List<Destination> destinations;
    private List<Passenger> passengers;

    public TravelPackage(String id, String name, Integer passengerCapacity, List<Destination> destinations,
            List<Passenger> passengers) {
        Id = id;
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.destinations = destinations;
        this.passengers = passengers;
    }

    /**
     * Constructs a TravelPackage object with the specified name, passenger capacity, and destinations.
     *
     * @param name              the name of the travel package
     * @param passengerCapacity the maximum capacity of passengers for the travel package
     * @param destinations      the list of destinations included in the travel package
     */
    public TravelPackage(String name, Integer passengerCapacity, List<Destination> destinations) {
        this.Id = UUID.randomUUID().toString().substring(0, 3);
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.destinations = destinations;
        this.passengers = new ArrayList<>();
    }

    /**
     * Constructs a TravelPackage object with the specified name, passenger capacity, destinations, and passengers.
     *
     * @param name              the name of the travel package
     * @param passengerCapacity the maximum capacity of passengers for the travel package
     * @param destinations      the list of destinations included in the travel package
     * @param passengers        the list of passengers enrolled in the travel package
     */
    public TravelPackage(String name, Integer passengerCapacity, List<Destination> destinations,
            List<Passenger> passengers) {
        this(name, passengerCapacity, destinations);
        this.passengers = passengers;
    }


    /**
     * Returns the ID of the travel package.
     *
     * @return the ID of the travel package
     */
    public String getId() {
        return Id;
    }

    /**
     * Sets the ID of the travel package.
     *
     * @param id the ID of the travel package
     */
    public void setId(String id) {
        Id = id;
    }

    /**
     * Returns the name of the travel package.
     *
     * @return the name of the travel package
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the travel package.
     *
     * @param name the name of the travel package
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the passenger capacity of the travel package.
     *
     * @return the passenger capacity of the travel package
     */
    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }

    /**
     * Sets the passenger capacity of the travel package.
     *
     * @param passengerCapacity the passenger capacity of the travel package
     */
    public void setPassengerCapacity(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    /**
     * Returns the list of destinations included in the travel package.
     *
     * @return the list of destinations
     */
    public List<Destination> getDestinations() {
        return destinations;
    }

    /**
     * Sets the list of destinations included in the travel package.
     *
     * @param destinations the list of destinations
     */
    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

    /**
     * Returns the list of passengers enrolled in the travel package.
     *
     * @return the list of passengers
     */
    public List<Passenger> getPassengers() {
        return passengers;
    }

    /**
     * Sets the list of passengers enrolled in the travel package.
     *
     * @param passengers the list of passengers
     */
    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}

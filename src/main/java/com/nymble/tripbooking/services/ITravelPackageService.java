package com.nymble.tripbooking.services;

/**
 * The ITravelPackageService interface defines the operations related to travel package services.
 */
public interface ITravelPackageService {

    /**
     * Prints the itinerary of the travel package.
     */
    public String printItinerary();

    /**
     * Prints the list of passengers enrolled in the travel package.
     */
    public String printPassengerList();

    /**
     * Prints the list of available activities in the travel package.
     */
    public String printAvailableActivities();
}

package com.nymble.tripbooking.services;

import com.nymble.tripbooking.Entitities.Activity;
import com.nymble.tripbooking.Entitities.Passenger;
import com.nymble.tripbooking.Entitities.PassengerType;

/**
 * The IPassengerService interface defines the operations related to passenger services.
 */
public interface IPassengerService {

    /**
     * Prints the details of the specified passenger.
     *
     * @param passenger the passenger whose details to print
     */
    public String printPassengersDetails(Passenger passenger);

    /**
     * Registers the specified passenger for the given activity.
     *
     * @param passenger the passenger to register
     * @param activity  the activity to register for
     */
    public void activityRegistration(Passenger passenger, Activity activity);

    /**
     * Calculates the discount amount for the specified passenger type and activity.
     *
     * @param passengerType the type of passenger
     * @param activity      the activity for which to calculate the discount
     * @return the discount amount
     */
    public Double calculateDiscount(PassengerType passengerType, Activity activity);

    /**
     * Checks if the specified passenger has sufficient balance to enroll in the given activity.
     *
     * @param passenger the passenger to check
     * @param activity  the activity to enroll in
     * @return true if the passenger has sufficient balance, false otherwise
     */
    public Boolean checkBalance(Passenger passenger, Activity activity);

    /**
     * Calculates the payment amount for the activity after applying the discount.
     *
     * @param cost           the original cost of the activity
     * @param discountAmount the discount amount
     * @return the payment amount after applying the discount
     */
    public double calculateActivityPayment(double cost, double discountAmount);
}

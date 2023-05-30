package com.nymble.tripbooking.services;

import com.nymble.tripbooking.Entitities.Activity;
import com.nymble.tripbooking.Entitities.Passenger;
import com.nymble.tripbooking.Entitities.PassengerType;
import com.nymble.tripbooking.Entitities.TravelPackage;
import com.nymble.tripbooking.exceptions.ActivityNotFoundException;
import com.nymble.tripbooking.exceptions.NoBalanceException;

/**
 * The PassengerService class provides operations related to passenger services.
 */
public class PassengerService implements IPassengerService {
    private TravelPackage travelPackage;

    /**
     * Constructs a PassengerService object with the specified travel package.
     *
     * @param travelPackage the travel package
     */
    public PassengerService(TravelPackage travelPackage) {
        this.travelPackage = travelPackage;
    }

    /**
     * Prints the details of the passenger, including name, number, and enrolled activities.
     *
     * @param passenger the passenger whose details will be printed
     */
    @Override
    public String printPassengersDetails(Passenger passenger) {
        StringBuilder output = new StringBuilder();
        output.append("Passenger Name: ").append(passenger.getName()).append("\n");
        output.append("Passenger Number: ").append(passenger.getPassengerNo()).append("\n");
        if (passenger.getPassengerType().equals(PassengerType.GOLD) || passenger.getPassengerType().equals(PassengerType.STANDARD)) {
            output.append("Balance: " +passenger.getBalance() +"\n");
        }
        output.append("Activities Signed Up:\n");
        for (Activity activity : passenger.getEnrolledActivities()) {
            output.append("- Destination: " + activity.getDestination().getName() + ", Activity: "
            + activity.getName() + ", Price paid: " + calculateActivityPayment(activity.getCost(), calculateDiscount(passenger.getPassengerType(), activity))).append("\n");
        }
        return output.toString();
    }

    /**
     * Registers a passenger for an activity.
     *
     * @param passenger the passenger to register
     * @param activity  the activity to register for
     * @throws ActivityNotFoundException if the activity is not found
     * @throws RuntimeException         if the activity is already enrolled by the passenger
     * @throws NoBalanceException        if the passenger does not have sufficient balance to register for the activity
     */
    @Override
    public void activityRegistration(Passenger passenger, Activity activity) {

        if (activity == null) {
            throw new ActivityNotFoundException("There is no Activity");
        }

        if (passenger.getEnrolledActivities().contains(activity)) {
            throw new RuntimeException("Activity is already enrolled");
        }

        if (passenger.getPassengerType().equals(PassengerType.STANDARD) || passenger.getPassengerType().equals(PassengerType.GOLD)) {
            if (!checkBalance(passenger, activity)) {
                throw new NoBalanceException("There is no balance");
            }
            double bal = passenger.getBalance() - calculateDiscount(passenger.getPassengerType(), activity);
            passenger.setBalance(bal);
        }

        activity.setNoActivityRegistration(activity);
        passenger.getEnrolledActivities().add(activity);

        if (travelPackage.getPassengers().contains(passenger)) {
            travelPackage.getPassengers().remove(passenger);
        }
        travelPackage.getPassengers().add(passenger);
    }

    /**
     * Calculates and returns the discount amount for a given passenger type and activity.
     *
     * @param passengerType the type of the passenger
     * @param activity      the activity for which to calculate the discount
     * @return the discount amount
     */
    @Override
    public Double calculateDiscount(PassengerType passengerType, Activity activity) {
        if (passengerType.equals(PassengerType.GOLD)) {
            return activity.getCost() * 0.1;
        } else if (passengerType.equals(PassengerType.STANDARD)) {
            return 0.0;
        } else {
            return activity.getCost();
        }
    }

    /**
     * Checks if the passenger has sufficient balance to register for the activity.
     *
     * @param passenger the passenger to check
     * @param activity  the activity to register for
     * @return true if the passenger has sufficient balance, false otherwise
     */
    @Override
    public Boolean checkBalance(Passenger passenger, Activity activity) {
        return passenger.getBalance() >= activity.getCost();
    }

    /**
     * Calculates and returns the payment amount for a given activity.
     *
     * @param cost           the cost of the activity
     * @param discountAmount the discount amount for the activity
     * @return the payment amount
     */
    @Override
    public double calculateActivityPayment(double cost, double discountAmount) {
        return cost - discountAmount;
    }
}

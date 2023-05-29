package com.nymble.tripbooking.Entitities;

import java.util.List;

public class Passenger {
    private String name;
    private Integer passengerNo;
    private Double balance;
    private PassengerType passengerType;
    private List<Activity> enrolledActivities;

    public Passenger(String name, Integer passengerNo, Double balance, PassengerType passengerType,
            List<Activity> enrolledActivities) {
        this.name = name;
        this.passengerNo = passengerNo;
        this.balance = balance;
        this.passengerType = passengerType;
        this.enrolledActivities = enrolledActivities;
    }

    public String getName() {
        return name;
    }

    public Integer getPassengerNo() {
        return passengerNo;
    }

    public Double getBalance() {
        return balance;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public List<Activity> getEnrolledActivities() {
        return enrolledActivities;
    }

    public void printPassengersDetails(){
        System.out.println("Passenger Name: " + this.getName());
        System.out.println("Passenger Number: " +  this.getPassengerNo());
        if(passengerType.equals(PassengerType.GOLD) || passengerType.equals(PassengerType.STANDARD))
        {
            System.out.println("Balance : " + getBalance());
        }
        System.out.println("Activities Signed Up:");
        for (Activity activity : enrolledActivities) {
            System.out.println("- Destination: " + activity.getDestination().getName() + ", Activity: "
                    + activity.getName() + ", Price: " + getPricePaid(activity.getCost()));
        }
    }

    public Double getPricePaid(Double cost)
    {
        if(passengerType.equals(PassengerType.GOLD)){
           return cost*0.1;
        }
        else if(passengerType.equals(PassengerType.STANDARD))
        {
            return cost;
        }
        else{
            return 0.0;
        }
    }

}

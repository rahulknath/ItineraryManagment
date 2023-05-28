package com.nymble.tripbooking.Entitities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TravelPackage{
    private Integer Id;
    private String name;
    private Integer passengerCapacity;
    private List<Destination> destinations;
    private List<Passenger> passengers;
    
    

    public TravelPackage(Integer id, String name, Integer passengerCapacity, List<Destination> destinations,
            List<Passenger> passengers) {
        Id = id;
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.destinations = destinations;
        this.passengers = passengers;
    }

    public void printItinerary()
    {
        System.out.println("Travel Package Name :" + this.name);
        for (Destination destination : destinations) {
            System.out.println("Destinations :");
            System.out.println(destination.getId()+ ". " + destination.getName());
            System.out.println("Activities :");
            List<Activity> activities  =  destination.getActivities();
            for (Activity activity : activities) {
                System.out.println(activity.getId() + ". Name: "+ activity.getName() + "\n  " + 
                " Cost: "+ activity.getCost() + "\n  " + 
                " Capacity: " + activity.getCapacity() + "\n  " + 
                " Description: " + activity.getDescription());
            }
        }
    }

    public void printEnrolledPassengers()
    {
        System.out.println("Package Name: " + this.name);
        System.out.println("Passenger Capacity: "+ this.passengerCapacity);
        System.out.println("No of Passengers Enrolled: "+ this.passengers.size());
        System.out.println("Passenger Details: ");
        Integer i = 1;
        for (Passenger passenger : passengers) {
            System.out.println(i + ". Name: "+ passenger.getName()+ " Number: " + passenger.getPassengerNo());
            i++;
        }
    }

    public void printActivityDetails()
    {
        System.out.println("Details of Activities: ");
        Map<Activity,Integer> mActivities = new HashMap<>();
        for (Passenger passenger : passengers) {
            List<Activity> lAct = passenger.getEnrolledActivities();
            for (Activity activity : lAct) {
                if(mActivities.containsKey(activity))
                {
                    mActivities.put(activity, mActivities.get(activity) + 1);
                }
                else{
                    mActivities.put(activity, 1);
                }
            }
        }

        for (Map.Entry<Activity,Integer> mEntry : mActivities.entrySet()) {
            mActivities.put(mEntry.getKey(), mEntry.getKey().getCapacity() - mEntry.getValue());
        }

        for (Map.Entry<Activity,Integer> mEntry : mActivities.entrySet()) {
            Activity activity = mEntry.getKey();
            System.out.println(activity.getId() + ". Name: "+ activity.getName() + "\n  " + 
            "Cost: "+ activity.getCost() + "\n  " + 
            "Capacity: " + activity.getCapacity() + "\n  " + 
            "Description: " + activity.getDescription() +"\n  "+
            "Available Capacity: " + mEntry.getValue());
        }
    }
}
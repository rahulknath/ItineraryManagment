/**

The Activity class represents an activity included in a travel package.
*/

package com.nymble.tripbooking.Entitities;

import java.util.UUID;

public class Activity {
    private String Id;
    private String name;
    private String description;
    private Double cost;
    private Integer capacity;
    private Destination destination;
    private Integer noActivityRegistration;

    /**
     * Constructs an Activity object with the specified parameters.
     *
     * @param id          the ID of the activity
     * @param name        the name of the activity
     * @param description the description of the activity
     * @param cost        the cost of the activity
     * @param capacity   the capacity of the activity
     * @param destination the destination where the activity takes place
     * @param noActivityRegistration the number of registration for the activity
     */
    public Activity(String name, String description, Double cost, Integer capacity,
            Destination destination) {
        Id = UUID.randomUUID().toString().substring(0, 3);
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
        this.noActivityRegistration = 0;
    }

    public Activity(String id, String name, String description, Double cost, Integer capacity, Destination destination,
            Integer noActivityRegistration) {
        Id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
        this.noActivityRegistration = noActivityRegistration;
    }

    /**
     * Returns the ID of the activity.
     *
     * @return the ID of the activity
     */
    public String getId() {
        return Id;
    }

    /**
     * Returns the name of the activity.
     *
     * @return the name of the activity
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of the activity.
     *
     * @return the description of the activity
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the cost of the activity.
     *
     * @return the cost of the activity
     */
    public Double getCost() {
        return cost;
    }

    /**
     * Returns the capacity of the activity.
     *
     * @return the capacity of the activity
     */
    public Integer getCapacity() {
        return capacity;
    }

    /**
     * Returns the destination where the activity takes place.
     *
     * @return the destination of the activity
     */
    public Destination getDestination() {
        return destination;
    }

    /**
     * Incrementing the noActivityRegistration after passenger registration.
     *
     */
    public void setNoActivityRegistration(Activity activity){
        if(activity!=null && activity.getId().equals(activity.getId()))
        {
            this.noActivityRegistration = this.noActivityRegistration + 1;
        }
    }

    /**
     * Returns the number of available capacity.
     *
     */
    public Integer getNumberOfAvialableCapacity(){
        return capacity - noActivityRegistration;
    }
}

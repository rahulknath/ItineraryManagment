/**

The Destination class represents a travel destination with its associated activities.
*/
package com.nymble.tripbooking.Entitities;

import java.util.List;
import java.util.UUID;

public class Destination {
    private String Id;
    private String name;
    private List<Activity> activities;

    /**
     * Constructs a Destination object with the specified parameters.
     *
     * @param name       the name of the destination
     * @param activities the list of activities available at the destination
     */
    public Destination(String name, List<Activity> activities) {
        Id = UUID.randomUUID().toString().substring(0, 3);
        ;
        this.name = name;
        this.activities = activities;
    }

    /**
     * Returns the ID of the destination.
     *
     * @return the ID of the destination
     */
    public String getId() {
        return Id;
    }

    /**
     * Returns the name of the destination.
     *
     * @return the name of the destination
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the list of activities available at the destination.
     *
     * @return the list of activities
     */
    public List<Activity> getActivities() {
        return activities;
    }

}

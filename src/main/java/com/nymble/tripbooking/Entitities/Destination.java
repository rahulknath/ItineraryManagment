/**
 * The Destination class represents a travel destination with its associated activities.
 */
package com.nymble.tripbooking.Entitities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.nymble.tripbooking.exceptions.ActivityNotFoundException;

public class Destination {
    private String Id;
    private String destinationName;
    private List<Activity> activities;

    public Destination(String id, String destinationName, List<Activity> activities) {
        Id = id;
        this.destinationName = destinationName;
        this.activities = activities;
    }

    /**
     * Constructs a Destination object with the specified parameters.
     *
     * @param destinationName the name of the destination
     */
    public Destination(String destinationName) {
        Id = UUID.randomUUID().toString().substring(0, 3);
        this.destinationName = destinationName;
        this.activities = new ArrayList<>();
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
        return destinationName;
    }

    /**
     * Returns the list of activities available at the destination.
     *
     * @return the list of activities
     */
    public List<Activity> getActivities() {
        return activities;
    }

    /**
     * Adds an activity to the list of activities available at the destination.
     *
     * @param activity the activity to be added
     * @throws ActivityNotFoundException if the activity is null
     * @throws RuntimeException         if the activity is already present in the destination
     */
    public void addActivities(Activity activity) {
        if (activity == null) {
            throw new ActivityNotFoundException("Activity not found");
        }

        if (activities.contains(activity)) {
            throw new RuntimeException("Activity is already present in the destination");
        }

        this.activities.add(activity);
    }
}

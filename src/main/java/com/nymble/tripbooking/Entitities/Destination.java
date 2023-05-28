package com.nymble.tripbooking.Entitities;

import java.util.List;

public class Destination {
    private Integer Id;
    private String name;
    private List<Activity> activities;
    public Destination(Integer id, String name, List<Activity> activities) {
        Id = id;
        this.name = name;
        this.activities = activities;
    }
    public Integer getId() {
        return Id;
    }
    public String getName() {
        return name;
    }
    public List<Activity> getActivities() {
        return activities;
    }
    
}

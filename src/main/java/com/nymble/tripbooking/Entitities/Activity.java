package com.nymble.tripbooking.Entitities;

public class Activity {
    private Integer Id;
    private String name;
    private String description;
    private Double cost;
    private Integer capacity;
    private Destination destination;
    public Activity(Integer id, String name, String description, Double cost, Integer capacity,
            Destination destination) {
        Id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
    }
    public Integer getId() {
        return Id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Double getCost() {
        return cost;
    }
    public Integer getCapacity() {
        return capacity;
    }
    public Destination getDestination() {
        return destination;
    }
   
    
}

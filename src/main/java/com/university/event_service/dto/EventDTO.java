package com.university.event_service.dto;

import java.time.LocalDateTime;

public class EventDTO {
    private String name;
    private String description;
    private String location;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer capacity;
    private Long organizerId;

    // Constructors
    public EventDTO() {}

    // Getters and setters
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public LocalDateTime getStartDate() { return startDate; }

    public void setStartDate(LocalDateTime startDate) { this.startDate = startDate; }

    public LocalDateTime getEndDate() { return endDate; }

    public void setEndDate(LocalDateTime endDate) { this.endDate = endDate; }

    public Integer getCapacity() { return capacity; }

    public void setCapacity(Integer capacity) { this.capacity = capacity; }

    public Long getOrganizerId() { return organizerId; }

    public void setOrganizerId(Long organizerId) { this.organizerId = organizerId; }
}
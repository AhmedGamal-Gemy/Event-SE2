package com.university.event_service.dto;

import com.university.event_service.model.Event;
import java.time.LocalDateTime;

public class EventResponseDTO {
    private Long id;
    private String name;
    private String description;
    private String location;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer capacity;
    private Event.EventStatus status;
    private Long organizerId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructors
    public EventResponseDTO() {}

    // Getters and setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

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

    public Event.EventStatus getStatus() { return status; }

    public void setStatus(Event.EventStatus status) { this.status = status; }

    public Long getOrganizerId() { return organizerId; }

    public void setOrganizerId(Long organizerId) { this.organizerId = organizerId; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
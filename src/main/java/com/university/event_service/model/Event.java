package com.university.event_service.model;

import java.time.LocalDateTime;

public class Event {
    // Enum for event status
    public enum EventStatus {
        UPCOMING, ONGOING, COMPLETED, CANCELLED
    }

    private Long id;
    private String name;
    private String description;
    private String location;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer capacity;
    private EventStatus status;
    private Long organizerId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructors, getters, setters
}
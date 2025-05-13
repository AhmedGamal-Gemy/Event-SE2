package com.university.event_service.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class Event {
    // Enum for event status
    public enum EventStatus {
        UPCOMING, ONGOING, COMPLETED, CANCELLED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
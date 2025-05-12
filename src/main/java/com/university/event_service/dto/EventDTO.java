// DTOs (Data Transfer Objects)
// EventDTO.java - Input DTO
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

    // Constructors, getters, setters
}
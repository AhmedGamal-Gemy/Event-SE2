// EventResponseDTO.java - Output DTO
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

    // Constructors, getters, setters
}

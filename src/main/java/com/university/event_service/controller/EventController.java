package com.university.event_service.controller;

import com.university.event_service.dto.EventDTO;
import com.university.event_service.dto.EventResponseDTO;
import com.university.event_service.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    // Constructor injection
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    /**
     * Create a new event
     */
    @PostMapping
    public ResponseEntity<EventResponseDTO> createEvent(@RequestBody EventDTO eventDTO) {
        EventResponseDTO createdEvent = eventService.createEvent(eventDTO);
        return ResponseEntity.status(201).body(createdEvent);
    }

    /** Retrieve all events */
    @GetMapping
    public ResponseEntity<List<EventResponseDTO>> getAllEvents() {
        List<EventResponseDTO> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    /** Get a specific event by ID */
    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDTO> getEventById(@PathVariable Long id) {
        EventResponseDTO event = eventService.getEventById(id);
        if(event != null) {
            return ResponseEntity.ok(event);
        }
        // لو الحدث مش موجود رجع 404
        return ResponseEntity.notFound().build();
    }

    /** Update an existing event */
    @PutMapping("/{id}")
    public ResponseEntity<EventResponseDTO> updateEvent(@PathVariable Long id, @RequestBody EventDTO eventDTO) {
        EventResponseDTO updatedEvent = eventService.updateEvent(id, eventDTO);
        if(updatedEvent != null) {
            return ResponseEntity.ok(updatedEvent);
        }
        return ResponseEntity.notFound().build();
    }

    /** Delete/Cancel an event */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    /** Reschedule an event */
    @PatchMapping("/{id}/reschedule")
    public ResponseEntity<EventResponseDTO> rescheduleEvent(
            @PathVariable Long id,
            @RequestParam LocalDateTime startDate,
            @RequestParam LocalDateTime endDate) {
        EventResponseDTO rescheduled = eventService.rescheduleEvent(id, startDate, endDate);
        if(rescheduled != null) {
            return ResponseEntity.ok(rescheduled);
        }
        return ResponseEntity.notFound().build();
    }

    /** Retrieve upcoming events */
    @GetMapping("/upcoming")
    public ResponseEntity<List<EventResponseDTO>> getUpcomingEvents() {
        List<EventResponseDTO> events = eventService.getUpcomingEvents();
        return ResponseEntity.ok(events);
    }

    /** Retrieve events by organizer */
    @GetMapping("/organizer/{organizerId}")
    public ResponseEntity<List<EventResponseDTO>> getEventsByOrganizer(@PathVariable Long organizerId) {
        List<EventResponseDTO> events = eventService.getEventsByOrganizer(organizerId);
        return ResponseEntity.ok(events);
    }
}
package com.university.event_service.service;

import com.university.event_service.dto.EventDTO;
import com.university.event_service.dto.EventResponseDTO;
import com.university.event_service.model.Event;
import com.university.event_service.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    /**
     * Create a new event
     * @param eventDTO Event details to create
     * @return Created event details
     */
    @Override
    public EventResponseDTO createEvent(EventDTO eventDTO) {
        Event event = new Event();
        event.setName(eventDTO.getName());
        event.setDescription(eventDTO.getDescription());
        event.setLocation(eventDTO.getLocation());
        event.setStartDate(eventDTO.getStartDate());
        event.setEndDate(eventDTO.getEndDate());
        event.setCapacity(eventDTO.getCapacity());
        event.setOrganizerId(eventDTO.getOrganizerId());
        event.setStatus(Event.EventStatus.UPCOMING); // Default status
        event.setCreatedAt(LocalDateTime.now());
        event.setUpdatedAt(LocalDateTime.now());

        Event savedEvent = eventRepository.save(event);

        return convertToResponseDTO(savedEvent);
    }

    /**
     * Retrieve all events
     * @return List of all events
     */
    @Override
    public List<EventResponseDTO> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    /**
     * Get event by its unique identifier
     * @param id Event's unique identifier
     * @return Event details
     */
    @Override
    public EventResponseDTO getEventById(Long id) {
        Optional<Event> event = eventRepository.findById(id);
        return event.map(this::convertToResponseDTO).orElse(null);
    }

    /**
     * Update an existing event
     * @param id Event's unique identifier
     * @param eventDTO Updated event details
     * @return Updated event details
     */
    @Override
    public EventResponseDTO updateEvent(Long id, EventDTO eventDTO) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            event.setName(eventDTO.getName());
            event.setDescription(eventDTO.getDescription());
            event.setLocation(eventDTO.getLocation());
            event.setStartDate(eventDTO.getStartDate());
            event.setEndDate(eventDTO.getEndDate());
            event.setCapacity(eventDTO.getCapacity());
            event.setUpdatedAt(LocalDateTime.now());

            Event updatedEvent = eventRepository.save(event);
            return convertToResponseDTO(updatedEvent);
        }
        return null;
    }

    /**
     * Delete/Cancel an event
     * @param id Event's unique identifier
     */
    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    /**
     * Reschedule an existing event
     * @param id Event's unique identifier
     * @param startDate New start date and time
     * @param endDate New end date and time
     * @return Rescheduled event details
     */
    @Override
    public EventResponseDTO rescheduleEvent(Long id, LocalDateTime startDate, LocalDateTime endDate) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            event.setStartDate(startDate);
            event.setEndDate(endDate);
            event.setUpdatedAt(LocalDateTime.now());

            Event rescheduledEvent = eventRepository.save(event);
            return convertToResponseDTO(rescheduledEvent);
        }
        return null;
    }

    /**
     * Retrieve upcoming events
     * @return List of upcoming events
     */
    @Override
    public List<EventResponseDTO> getUpcomingEvents() {
        return eventRepository.findByStatus(Event.EventStatus.UPCOMING).stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    /**
     * Retrieve events created by a specific organizer
     * @param organizerId Organizer's unique identifier
     * @return List of events by the organizer
     */
    @Override
    public List<EventResponseDTO> getEventsByOrganizer(Long organizerId) {
        return eventRepository.findByOrganizerId(organizerId).stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    private EventResponseDTO convertToResponseDTO(Event event) {
        EventResponseDTO response = new EventResponseDTO();
        response.setId(event.getId());
        response.setName(event.getName());
        response.setDescription(event.getDescription());
        response.setLocation(event.getLocation());
        response.setStartDate(event.getStartDate());
        response.setEndDate(event.getEndDate());
        response.setCapacity(event.getCapacity());
        response.setStatus(event.getStatus());
        response.setOrganizerId(event.getOrganizerId());
        response.setCreatedAt(event.getCreatedAt());
        response.setUpdatedAt(event.getUpdatedAt());
        return response;
    }
}
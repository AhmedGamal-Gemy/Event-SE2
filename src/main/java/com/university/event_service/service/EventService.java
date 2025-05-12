package com.university.event_service.service;

import com.university.event_service.dto.EventDTO;
import com.university.event_service.dto.EventResponseDTO;
import com.university.event_service.model.Event;
import java.time.LocalDateTime;
import java.util.List;

public interface EventService {

    EventResponseDTO createEvent(EventDTO eventDTO);


    List<EventResponseDTO> getAllEvents();


    EventResponseDTO getEventById(Long id);


    EventResponseDTO updateEvent(Long id, EventDTO eventDTO);


    void deleteEvent(Long id);


    EventResponseDTO rescheduleEvent(Long id, LocalDateTime startDate, LocalDateTime endDate);


    List<EventResponseDTO> getUpcomingEvents();


    List<EventResponseDTO> getEventsByOrganizer(Long organizerId);
}
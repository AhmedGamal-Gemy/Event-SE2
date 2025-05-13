package com.university.event_service.repository;

import com.university.event_service.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    /**
     * Find events by organizer ID
     * @param organizerId The ID of the event organizer
     * @return List of events created by the specified organizer
     */
    List<Event> findByOrganizerId(Long organizerId);

    /**
     * Find upcoming events
     * @param currentDateTime Current date and time
     * @return List of upcoming events
     */
    @Query("SELECT e FROM Event e WHERE e.startDate > :currentDateTime AND e.status = com.university.event_service.model.Event.EventStatus.UPCOMING ORDER BY e.startDate ASC")
    List<Event> findUpcomingEvents(@Param("currentDateTime") LocalDateTime currentDateTime);

    /**
     * Find events within a specific date range
     * @param startDate Start of the date range
     * @param endDate End of the date range
     * @return List of events within the specified date range
     */
    List<Event> findByStartDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    /**
     * Find events by status
     * @param status Event status
     * @return List of events with the specified status
     */
    List<Event> findByStatus(Event.EventStatus status);

    /**
     * Find events by location
     * @param location Event location
     * @return List of events at the specified location
     */
    List<Event> findByLocation(String location);
}
// RegistrationDTO.java - Input DTO
package com.university.registration_service.dto;

public class RegistrationDTO {
    private Long eventId;
    private ParticipantDTO participant;

    // Constructors, getters, setters
    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public ParticipantDTO getParticipant() {
        return participant;
    }

    public void setParticipant(ParticipantDTO participant) {
        this.participant = participant;
    }
}


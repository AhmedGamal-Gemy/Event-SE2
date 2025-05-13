package com.university.registration_service.dto;

import com.university.registration_service.model.Registration;
import java.time.LocalDateTime;

public class RegistrationResponseDTO {
    private Long id;
    private Long eventId;
    private ParticipantDTO participant;
    private LocalDateTime registrationDate;
    private Registration.RegistrationStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Registration.RegistrationStatus getStatus() {
        return status;
    }

    public void setStatus(Registration.RegistrationStatus status) {
        this.status = status;
    }
}
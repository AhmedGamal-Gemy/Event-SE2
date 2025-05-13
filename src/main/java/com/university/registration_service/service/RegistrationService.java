package com.university.registration_service.service;

import com.university.registration_service.dto.ParticipantDTO;
import com.university.registration_service.dto.RegistrationDTO;
import com.university.registration_service.dto.RegistrationResponseDTO;
import com.university.registration_service.model.Registration;
import java.util.List;

public interface RegistrationService {
    /**
     * Register a participant for an event
     * @param registrationDTO Registration details
     * @return Registration response with details
     */
    RegistrationResponseDTO register(RegistrationDTO registrationDTO);

    /**
     * Cancel an existing registration
     * @param registrationId Unique identifier of the registration
     */
    void cancelRegistration(Long registrationId);

    /**
     * Get all registrations for a specific event
     * @param eventId Unique identifier of the event
     * @return List of registrations for the event
     */
    List<RegistrationResponseDTO> getRegistrationsByEvent(Long eventId);

    /**
     * Get all registrations for a specific participant
     * @param participantId Unique identifier of the participant
     * @return List of registrations for the participant
     */
    List<RegistrationResponseDTO> getRegistrationsByParticipant(Long participantId);

    /**
     * Get a specific registration by its ID
     * @param registrationId Unique identifier of the registration
     * @return Registration details
     */
    RegistrationResponseDTO getRegistrationById(Long registrationId);

    /**
     * Check if an event is full
     * @param eventId Unique identifier of the event
     * @return true if event is full, false otherwise
     */
    boolean isEventFull(Long eventId);

    /**
     * Create a new participant
     * @param participantDTO Participant details
     * @return Created participant details
     */
    ParticipantDTO createParticipant(ParticipantDTO participantDTO);
}
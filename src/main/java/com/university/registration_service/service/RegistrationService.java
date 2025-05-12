package com.university.registration_service.service;

import com.university.registration_service.dto.ParticipantDTO;
import com.university.registration_service.dto.RegistrationDTO;

import java.util.List;

public interface RegistrationService {
    ParticipantDTO register(RegistrationDTO registrationDTO);
    void cancelRegistration(Long registrationId);
    List<ParticipantDTO> getRegistrationsByEvent(Long eventId);
    List<ParticipantDTO> getRegistrationsByParticipant(Long participantId);
    ParticipantDTO getRegistrationById(Long registrationId);
    boolean isEventFull(Long eventId);
    ParticipantDTO createParticipant(ParticipantDTO participantDTO);
}

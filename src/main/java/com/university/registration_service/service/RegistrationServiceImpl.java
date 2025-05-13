package com.university.registration_service.service;

import com.university.registration_service.dto.RegistrationDTO;
import com.university.registration_service.model.Participant;
import com.university.registration_service.model.Registration;
import com.university.registration_service.repository.ParticipantRepository;
import com.university.registration_service.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/*

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final ParticipantRepository participantRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public RegistrationServiceImpl(
            RegistrationRepository registrationRepository,
            ParticipantRepository participantRepository,
            RestTemplate restTemplate) {
        this.registrationRepository = registrationRepository;
        this.participantRepository = participantRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    @Transactional
    public Registration registerForEvent(RegistrationDTO registrationDTO) {
        // Check if participant exists
        Participant participant = participantRepository.findById(registrationDTO.getParticipantId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Participant not found with id: " + registrationDTO.getParticipantId()));

        // Check if participant is already registered for this event
        Optional<Registration> existingRegistration = registrationRepository
                .findByEventIdAndParticipantId(
                        registrationDTO.getEventId(),
                        registrationDTO.getParticipantId());

        if (existingRegistration.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Participant is already registered for this event");
        }

        // Check event capacity (call to Event Service)
        checkEventCapacity(registrationDTO.getEventId());

        // Create new registration
        Registration registration = new Registration();
        registration.setEventId(registrationDTO.getEventId());
        registration.setParticipant(participant);
        registration.setRegistrationDate(LocalDateTime.now());
        registration.setStatus("CONFIRMED");
        registration.setCreatedAt(LocalDateTime.now());
        registration.setUpdatedAt(LocalDateTime.now());

        return registrationRepository.save(registration);
    }

    @Override
    @Transactional
    public void cancelRegistration(Long registrationId) {
        Registration registration = registrationRepository.findById(registrationId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Registration not found with id: " + registrationId));

        registration.setStatus("CANCELLED");
        registration.setUpdatedAt(LocalDateTime.now());
        registrationRepository.save(registration);
    }

    @Override
    public List<Registration> getRegistrationsByEventId(Long eventId) {
        return registrationRepository.findByEventId(eventId);
    }

    @Override
    public List<Registration> getRegistrationsByParticipantId(Long participantId) {
        return registrationRepository.findByParticipantId(participantId);
    }

    @Override
    public Registration getRegistrationById(Long registrationId) {
        return registrationRepository.findById(registrationId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Registration not found with id: " + registrationId));
    }

    @Override
    @Transactional
    public Registration updateRegistrationStatus(Long registrationId, String status) {
        Registration registration = registrationRepository.findById(registrationId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Registration not found with id: " + registrationId));

        registration.setStatus(status);
        registration.setUpdatedAt(LocalDateTime.now());
        return registrationRepository.save(registration);
    }

    // Helper method to check event capacity with Event Service
    private void checkEventCapacity(Long eventId) {
        // Using RestTemplate to call Event Service
        try {
            // This would be replaced with actual service discovery mechanism
            String eventServiceUrl = "http://event-service/api/events/" + eventId + "/check-capacity";
            Boolean hasCapacity = restTemplate.getForObject(eventServiceUrl, Boolean.class);

            if (hasCapacity == null || !hasCapacity) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Event has reached maximum capacity");
            }
        } catch (Exception e) {
            // In case of communication error
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,
                    "Unable to verify event capacity: " + e.getMessage());
        }
    }

    // Method to verify participant eligibility (could include age restrictions, membership, etc.)
    private void verifyParticipantEligibility(Long participantId, Long eventId) {
        // Implementation would depend on business rules
        // Could call another service or check against internal rules
    }
}*/
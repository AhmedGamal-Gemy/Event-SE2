package com.university.registration_service.controller;

import com.university.registration_service.dto.ParticipantDTO;
import com.university.registration_service.dto.RegistrationDTO;
import com.university.registration_service.dto.RegistrationResponseDTO;
import com.university.registration_service.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {
    private final RegistrationService registrationService;

    // Constructor injection
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    /**
     * Register for an event
     *
     * @param registrationDTO Registration details
     * @return Created registration
     */
    @PostMapping
    public ResponseEntity<RegistrationResponseDTO> register(@RequestBody RegistrationDTO registrationDTO) {
        return null;
    }

    /**
     * Cancel a registration
     *
     * @param registrationId Unique identifier of the registration
     * @return No content response
     */
    @DeleteMapping("/{registrationId}")
    public ResponseEntity<Void> cancelRegistration(@PathVariable Long registrationId) {
        return null;
    }

    /**
     * Get registrations for a specific event
     *
     * @param eventId Unique identifier of the event
     * @return List of registrations
     */
    @GetMapping("/events/{eventId}")
    public ResponseEntity<List<RegistrationResponseDTO>> getRegistrationsByEvent(@PathVariable Long eventId) {
        return null;
    }

    /**
     * Get registrations for a specific participant
     *
     * @param participantId Unique identifier of the participant
     * @return List of registrations
     */
    @GetMapping("/participants/{participantId}")
    public ResponseEntity<List<RegistrationResponseDTO>> getRegistrationsByParticipant(@PathVariable Long participantId) {
        return null;
    }

    /**
     * Get a specific registration
     *
     * @param registrationId Unique identifier of the registration
     * @return Registration details
     */
    @GetMapping("/{registrationId}")
    public ResponseEntity<RegistrationResponseDTO> getRegistrationById(@PathVariable Long registrationId) {
        return null;
    }

    /**
     * Check if an event is full
     *
     * @param eventId Unique identifier of the event
     * @return Boolean indicating if event is full
     */
    @GetMapping("/events/{eventId}/capacity")
    public ResponseEntity<Boolean> isEventFull(@PathVariable Long eventId) {
        return null;
    }

    /**
     * Create a new participant
     *
     * @param participantDTO Participant details
     * @return Created participant
     */
    @PostMapping("/participants")
    public ResponseEntity<ParticipantDTO> createParticipant(@RequestBody ParticipantDTO participantDTO) {
        return null;
    }
}
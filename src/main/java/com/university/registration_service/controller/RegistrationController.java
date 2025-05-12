package com.university.registration_service.controller;

import com.university.registration_service.dto.*;
import com.university.registration_service.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public ResponseEntity<ParticipantDTO> register(@RequestBody RegistrationDTO registrationDTO) {
        return ResponseEntity.ok(registrationService.register(registrationDTO));
    }

    @DeleteMapping("/{registrationId}")
    public ResponseEntity<Void> cancelRegistration(@PathVariable Long registrationId) {
        registrationService.cancelRegistration(registrationId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/events/{eventId}")
    public ResponseEntity<List<ParticipantDTO>> getRegistrationsByEvent(@PathVariable Long eventId) {
        return ResponseEntity.ok(registrationService.getRegistrationsByEvent(eventId));
    }

    @GetMapping("/participants/{participantId}")
    public ResponseEntity<List<ParticipantDTO>> getRegistrationsByParticipant(@PathVariable Long participantId) {
        return ResponseEntity.ok(registrationService.getRegistrationsByParticipant(participantId));
    }

    @GetMapping("/{registrationId}")
    public ResponseEntity<ParticipantDTO> getRegistrationById(@PathVariable Long registrationId) {
        return ResponseEntity.ok(registrationService.getRegistrationById(registrationId));
    }

    @GetMapping("/events/{eventId}/capacity")
    public ResponseEntity<Boolean> isEventFull(@PathVariable Long eventId) {
        return ResponseEntity.ok(registrationService.isEventFull(eventId));
    }

    @PostMapping("/participants")
    public ResponseEntity<ParticipantDTO> createParticipant(@RequestBody ParticipantDTO participantDTO) {
        return ResponseEntity.ok(registrationService.createParticipant(participantDTO));
    }
}

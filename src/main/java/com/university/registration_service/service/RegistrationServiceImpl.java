package com.university.registration_service.service;

import com.university.registration_service.dto.*;
import com.university.registration_service.model.*;
import com.university.registration_service.repository.*;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final ParticipantRepository participantRepository;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository, ParticipantRepository participantRepository) {
        this.registrationRepository = registrationRepository;
        this.participantRepository = participantRepository;
    }

    @Override
    public ParticipantDTO register(RegistrationDTO dto) {
        Participant participant = toEntity(dto.getParticipant());
        if (participant.getId() == null) {
            participant = participantRepository.save(participant);
        }

        Registration registration = new Registration();
        registration.setEventId(dto.getEventId());
        registration.setParticipant(participant);
        registration.setRegistrationDate(LocalDateTime.now());
        registration.setStatus(Registration.EventStatus.CONFIRMED); // Simplified logic

        Registration saved = registrationRepository.save(registration);
        return toDTO(saved);
    }

    @Override
    public void cancelRegistration(Long id) {
        Registration reg = registrationRepository.findById(id).orElseThrow();
        reg.setStatus(Registration.EventStatus.CANCELLED);
        registrationRepository.save(reg);
    }

    @Override
    public List<ParticipantDTO> getRegistrationsByEvent(Long eventId) {
        return registrationRepository.findByEventId(eventId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ParticipantDTO> getRegistrationsByParticipant(Long participantId) {
        return registrationRepository.findByParticipantId(participantId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ParticipantDTO getRegistrationById(Long id) {
        return registrationRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow();
    }

    @Override
    public boolean isEventFull(Long eventId) {
        int capacity = 100; // Placeholder
        return registrationRepository.countByEventId(eventId) >= capacity;
    }

    @Override
    public ParticipantDTO createParticipant(ParticipantDTO dto) {
        Participant saved = participantRepository.save(toEntity(dto));
        return toDTO(saved);
    }
            //public ParticipantDTO(Long id, String name, String email, String phone) {}
    private ParticipantDTO toDTO(Registration r) {
//        return new ParticipantDTO(
//                r.getId(),
//                r.getEventId(),
//                toDTO(r.getParticipant()),
//                r.getRegistrationDate(),
//                r.getStatus()
//        );
        return null;
    }

    private ParticipantDTO toDTO(Participant p) {
        return new ParticipantDTO(p.getId(), p.getName(), p.getEmail(), p.getPhone());
    }

    private Participant toEntity(ParticipantDTO dto) {
        Participant p = new Participant();
        p.setId(dto.getId());
        p.setName(dto.getName());
        p.setEmail(dto.getEmail());
        p.setPhone(dto.getPhone());
        p.setCreatedAt(LocalDateTime.now());
        p.setUpdatedAt(LocalDateTime.now());
        return p;
    }
}

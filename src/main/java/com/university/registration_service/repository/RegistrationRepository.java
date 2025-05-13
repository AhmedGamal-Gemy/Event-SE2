package com.university.registration_service.repository;

import com.university.registration_service.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
//    List<Registration> findByEventId(Long eventId);
//    List<Registration> findByParticipantId(Long participantId);
//    int countByEventId(Long eventId);
}

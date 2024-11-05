package com.josesiyo_robbio.speed_dating.repository;

import com.josesiyo_robbio.speed_dating.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RegistrationRepository extends JpaRepository<Registration, Long>
{
    boolean existsByEventIdAndParticipantEmail(Long eventId, String participantEmail);
}
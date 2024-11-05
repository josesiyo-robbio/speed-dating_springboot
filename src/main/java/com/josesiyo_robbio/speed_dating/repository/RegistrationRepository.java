package com.josesiyo_robbio.speed_dating.repository;

import com.josesiyo_robbio.speed_dating.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long>
{
    // Metodo para verificar si el participante está registrado en un evento
    boolean existsByEventIdAndParticipantEmail(Long eventId, String participantEmail);
}
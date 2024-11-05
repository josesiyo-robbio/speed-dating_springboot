package com.josesiyo_robbio.speed_dating.model;

import java.io.Serializable;
import java.util.Objects;

public class RegistrationId implements Serializable
{
    private Long eventId;
    private String participantEmail;

    // Empty constructor required for serialization
    public RegistrationId() {}

    // GETTERS
    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }


    //SETTERS
    public String getParticipantEmail() { return participantEmail; }
    public void setParticipantEmail(String participantEmail) { this.participantEmail = participantEmail; }

    // hashCode and equals to ensure equality
    @Override
    public int hashCode()
    {
        return Objects.hash(eventId, participantEmail);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!(obj instanceof RegistrationId)) return false;
        RegistrationId that = (RegistrationId) obj;
        return Objects.equals(eventId, that.eventId) &&
                Objects.equals(participantEmail, that.participantEmail);
    }
}


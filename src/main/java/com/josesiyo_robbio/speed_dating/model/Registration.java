package com.josesiyo_robbio.speed_dating.model;

import jakarta.persistence.*;



@Entity
@Table(name = "registrations")
@IdClass(RegistrationId.class)
public class Registration
{
    @Id
    @Column(name = "event_id")
    private Long eventId;

    @Id
    @Column(name = "participant_email")
    private String participantEmail;

    @Column(name = "participant_name")
    private String participantName;

    @Column(name = "participant_gender")
    private String participantGender;


    //GETTERS
    public Long getEventId()                   { return eventId;           }
    public String getParticipantEmail()        { return participantEmail;  }
    public String getParticipantName()         { return participantName;   }
    public String getParticipantGender()       { return participantGender; }


    //SETTERS
    public void setEventId(Long eventId)                        { this.eventId = eventId;                       }
    public void setParticipantEmail(String participantEmail)    { this.participantEmail = participantEmail;     }
    public void setParticipantName(String participantName)      { this.participantName = participantName;       }
    public void setParticipantGender(String participantGender)  { this.participantGender = participantGender;   }

}

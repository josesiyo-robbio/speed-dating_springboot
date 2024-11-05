package com.josesiyo_robbio.speed_dating.dto;

import jakarta.validation.constraints.NotBlank;

public class RegistrationDto
{

    @NotBlank()
    private Long id;

    @NotBlank()
    private String participantEmail;

    @NotBlank()
    private String participantName;

    @NotBlank()
    private String participantGender;


    //GETTERS
    public Long getId()                     { return id;                }
    public String getParticipantEmail()     { return participantEmail;  }
    public String getParticipantName()      { return participantName;   }
    public String getParticipantGender()    { return participantGender; }


    //SETTERS
    public void setId(long id)                                  { this.id = id;                                 }
    public void setParticipantEmail(String participantEmail)    { this.participantEmail = participantEmail;     }
    public void setParticipantName(String participantName)      { this.participantName = participantName;       }
    public void setParticipantGender(String participantGender)  { this.participantGender = participantGender;   }
}
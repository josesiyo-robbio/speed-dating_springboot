package com.josesiyo_robbio.speed_dating.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class VoteDto
{

    @NotBlank
    private Long id;

    @NotBlank
    private String voterEmail;

    @NotBlank
    @JsonProperty("voted_email") // Añade esta anotación
    private String votedEmail;

    @NotBlank
    private Long eventId;

    private String message;


    // GETTERS
    public Long getId()             { return id;            }
    public String getVoterEmail()   { return voterEmail;    }
    public String getVotedEmail()   { return votedEmail;    }
    public Long getEventId()        { return eventId;       }
    public String getMessage()      { return message;       }


    // SETTERS
    public void setId(Long id)                      { this.id = id;                 }
    public void setVoterEmail(String voterEmail)    { this.voterEmail = voterEmail; }
    public void setVotedEmail(String votedEmail)    { this.votedEmail = votedEmail; }
    public void setEventId(Long eventId)            { this.eventId = eventId;       }
    public void setMessage(String message)          { this.message = message;       }
}

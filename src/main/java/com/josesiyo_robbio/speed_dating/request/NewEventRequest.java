package com.josesiyo_robbio.speed_dating.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.josesiyo_robbio.speed_dating.dto.ParticipantDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.List;



public class NewEventRequest
{
    @NotBlank(message = "name cannot be empty")
    private String name;

    @NotNull
    @Positive
    private int duration;

    private String dateTime;

    private List<ParticipantDto> participants;

    @JsonProperty("event_id")
    private Long id;


    //GETTERS
    public Long getId()                             { return id;            }
    public int getDuration()                        { return duration;      }
    public String getName()                         { return name;          }
    public String getDateTime()                     { return dateTime;      }
    public List<ParticipantDto> getParticipants()   { return participants;  }


    //SETTERS
    public void setId(Long id)                                      { this.id = id;                     }
    public void setName(String name)                                { this.name = name;                 }
    public void setDuration(int duration)                           { this.duration = duration;         }
    public void setDateTime(String dateTime)                        { this.dateTime = dateTime;         }
    public void setParticipants(List<ParticipantDto> participants)  { this.participants = participants; }
}
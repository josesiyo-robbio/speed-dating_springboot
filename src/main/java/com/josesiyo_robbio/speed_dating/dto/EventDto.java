package com.josesiyo_robbio.speed_dating.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.List;



public class EventDto
{
    @Positive
    @NotNull
    private Long id;

    @NotNull
    private String name;

    @Positive
    private int duration;

    @NotNull
    private String dateTime;

    private List<ParticipantDto> participants;

    private List<List<Object>> rotations;

    private String message;


    // Getters
    public Long getId()                             { return id;            }
    public String getName()                         { return name;          }
    public int getDuration()                        { return duration;      }
    public String getDateTime()                     { return dateTime;      }
    public List<ParticipantDto> getParticipants()   { return participants;  }
    public List<List<Object>> getRotations()        { return rotations;     }
    public String getMessage()                      { return message;       }


    // Setters
    public void setId(Long id)                                      { this.id = id;                         }
    public void setName(String name)                                { this.name = name;                     }
    public void setDuration(int duration)                           { this.duration = duration;             }
    public void setDateTime(String dateTime)                        { this.dateTime = dateTime;             }
    public void setParticipants(List<ParticipantDto> participants)  { this.participants = participants;     }
    public void setRotations(List<List<Object>> rotations)          { this.rotations = rotations;           }
    public void setMessage(String message)                          { this.message = message;               }

}
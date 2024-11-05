package com.josesiyo_robbio.speed_dating.response;

import java.util.List;



public class NewEventResponse
{
    private String message;
    private Long eventId;
    private List<List<Object>> rotations;


    // GETTERS
    public String getMessage()                  { return message;   }
    public Long getEventId()                    { return eventId;   }
    public List<List<Object>> getRotations()    { return rotations; }


    //SETTERS
    public void setMessage(String message)                  { this.message = message;       }
    public void setEventId(Long eventId)                    { this.eventId = eventId;       }
    public void setRotations(List<List<Object>> rotations)  { this.rotations = rotations;   }

}
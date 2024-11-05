package com.josesiyo_robbio.speed_dating.response;

import java.util.List;



public class NewEventResponse
{
    private String message;
    private Long eventId;
    private List<List<Object>> rotations;

    // GETTERS and SETTERS
    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Long getEventId()
    {
        return eventId;
    }

    public void setEventId(Long eventId)
    {
        this.eventId = eventId;
    }

    public List<List<Object>> getRotations()
    {
        return rotations;
    }

    public void setRotations(List<List<Object>> rotations)
    {
        this.rotations = rotations;
    }
}
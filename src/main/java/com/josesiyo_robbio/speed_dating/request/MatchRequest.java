package com.josesiyo_robbio.speed_dating.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public class MatchRequest
{
    @JsonProperty("eventId")
    @NotNull(message = "eventId must not be null")
    private Long eventId;

    public Long getEventId()
    {
        return eventId;
    }

    public void setEventId(Long eventId)
    {
        this.eventId = eventId;
    }
}

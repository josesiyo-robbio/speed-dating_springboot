package com.josesiyo_robbio.speed_dating.controller;


import com.josesiyo_robbio.speed_dating.dto.EventDto;
import com.josesiyo_robbio.speed_dating.request.NewEventRequest;
import com.josesiyo_robbio.speed_dating.response.NewEventResponse;
import com.josesiyo_robbio.speed_dating.service.NewEventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class newEventController
{
    @Autowired
    private NewEventService eventService;

    @PostMapping("/new")
    public ResponseEntity<NewEventResponse> createNewEvent(@RequestBody @Valid NewEventRequest newEventRequest) {
        // Convert EventRequest to EventDto
        EventDto eventDto = new EventDto();
        eventDto.setName(newEventRequest.getName());
        eventDto.setDuration(newEventRequest.getDuration());
        eventDto.setDateTime(newEventRequest.getDateTime());
        eventDto.setParticipants(newEventRequest.getParticipants());

        // Call the service and get the result
        EventDto createdEvent = eventService.createNewEvent(eventDto);

        // Convert EventDto result to EventResponse
        NewEventResponse response = new NewEventResponse();
        response.setMessage(createdEvent.getMessage());
        response.setEventId(createdEvent.getId());
        response.setRotations(createdEvent.getRotations());

        return ResponseEntity.ok(response);
    }
}

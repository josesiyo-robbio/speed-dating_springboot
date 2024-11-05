package com.josesiyo_robbio.speed_dating.service;

import com.josesiyo_robbio.speed_dating.dto.EventDto;
import com.josesiyo_robbio.speed_dating.dto.ParticipantDto;
import com.josesiyo_robbio.speed_dating.model.Event;
import com.josesiyo_robbio.speed_dating.model.Registration;
import com.josesiyo_robbio.speed_dating.repository.EventRepository;
import com.josesiyo_robbio.speed_dating.repository.RegistrationRepository;
import jakarta.mail.MessagingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;



@Service
public class NewEventService
{
    private static final Logger log = LoggerFactory.getLogger(NewEventService.class);

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private JwtService jwtService;


    public NewEventService(EventRepository eventRepository, RegistrationRepository registrationRepository)
    {
        this.eventRepository = eventRepository;
        this.registrationRepository = registrationRepository;
    }


    @Transactional
    public EventDto createNewEvent(EventDto eventDto)
    {
        try
        {
            //transaction #1 - Insert in table events
            Event event = new Event();
            event.setName(eventDto.getName());
            event.setDuration(eventDto.getDuration());
            String dateTimeStr = String.valueOf(eventDto.getDateTime());
            Timestamp dateTime = Timestamp.valueOf(dateTimeStr);
            event.setDateTime(dateTime);
            Event savedEvent = eventRepository.save(event);


            //transaction #2 - Insert new participants in table registrations
            for (ParticipantDto participantDto : eventDto.getParticipants())
            {
                Registration registration = new Registration();
                registration.setEventId(savedEvent.getId());
                registration.setParticipantEmail(participantDto.getEmail());
                registration.setParticipantName(participantDto.getName());
                registration.setParticipantGender(participantDto.getGender());
                registrationRepository.save(registration);
            }


            // Create a rotations
            List<List<Object>> rotations = RotationService.generateRotations(eventDto.getParticipants(), eventDto.getDuration(), dateTime);


            //sending emails
            for (ParticipantDto participantDto : eventDto.getParticipants())
            {
                String token = jwtService.generateToken(new HashMap<String, Object>() {{
                    put("email", participantDto.getEmail());
                    put("event_id", savedEvent.getId());
                }});

                emailService.sendEmail(message -> {
                    try
                    {
                        MimeMessageHelper helper = new MimeMessageHelper(message, true);
                        helper.setFrom("Event Organizer <your-email@example.com>");
                        helper.setTo(participantDto.getEmail());
                        helper.setSubject("Welcome to the " + eventDto.getName() + " Event!");
                        helper.setText("Hello " + participantDto.getName() + ",\n\n" +
                                "Your participation in the event \"" + eventDto.getName() + "\" has been confirmed!\n\n" +
                                "Event Date: " + eventDto.getDateTime() + "\n" +
                                "Duration: " + eventDto.getDuration() + " minutes\n\n" +
                                "Access Token: " + token + "\n\n" +
                                "Best regards,\n" +
                                "Event Organizer");
                    }
                    catch (MessagingException e)
                    {
                        e.printStackTrace();
                    }
                });
            }


            EventDto newEVent = new EventDto();
            newEVent.setId(savedEvent.getId());
            newEVent.setRotations(rotations);
            newEVent.setMessage("Event created successfully");
            return newEVent;
        }
        catch (Exception e)
        {
            log.error("Error creating event", e);
            throw e;
        }
    }

}


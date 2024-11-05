package com.josesiyo_robbio.speed_dating.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(MimeMessagePreparator messagePreparator)
    {
        mailSender.send(messagePreparator);
    }
}
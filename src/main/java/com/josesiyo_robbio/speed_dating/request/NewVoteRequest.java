package com.josesiyo_robbio.speed_dating.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class NewVoteRequest
{

    @NotBlank(message = "Voted email cannot be empty")
    @Email(message = "Invalid email format")
    private String votedEmail;

    // Getter and Setter
    public String getVotedEmail()
    {
        return votedEmail;
    }

    public void setVotedEmail(String votedEmail)
    {
        this.votedEmail = votedEmail;
    }
}

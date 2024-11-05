package com.josesiyo_robbio.speed_dating.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;



public class ParticipantDto
{

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Gender cannot be empty")
    private String gender;

    // GETTERS
    public String getEmail()    { return email;     }
    public String getName()     { return name;      }
    public String getGender()   { return gender;    }


    //SETTERS
    public void setEmail(String email)      { this.email = email;   }
    public void setName(String name)        { this.name = name;     }
    public void setGender(String gender)    { this.gender = gender; }

}
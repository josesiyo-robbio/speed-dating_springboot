package com.josesiyo_robbio.speed_dating.model;



public class Participant
{
    private String name;
    private String gender;

    public Participant(String name, String gender)
    {
        this.name = name;
        this.gender = gender;
    }


    // GETTERS
    public String getName()     { return name;      }
    public String getGender()   { return gender;    }


    //SETTERS
    public void setName(String name)        { this.name = name;         }
    public void setGender(String gender)    { this.gender = gender;     }
}
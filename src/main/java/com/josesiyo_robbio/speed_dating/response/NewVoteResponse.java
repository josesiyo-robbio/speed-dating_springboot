package com.josesiyo_robbio.speed_dating.response;



public class NewVoteResponse
{
    private String message;


    public NewVoteResponse(String message)
    {
        this.message = message;
    }


    //GETTERS AND SETTERS
    public String getMessage()              { return message;           }
    public void setMessage(String message)  { this.message = message;   }
}

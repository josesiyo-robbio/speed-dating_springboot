package com.josesiyo_robbio.speed_dating.model;

import jakarta.persistence.*;

@Entity
@Table(name = "votes")
public class Vote
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "voter_email")
    private String voterEmail;

    @Column(name = "voted_email")
    private String votedEmail;

    @Column(name = "event_id")
    private Long eventId;


    //GETTERS
    public Long getId()             { return id;            }
    public String getVoterEmail()   { return voterEmail;    }
    public String getVotedEmail()   { return votedEmail;    }
    public Long getEventId()        { return eventId;       }


    //SETTERS
    public void setId(Long id)                      { this.id = id;                     }
    public void setVoterEmail(String voterEmail)    { this.voterEmail = voterEmail;     }
    public void setVotedEmail(String votedEmail)    { this.votedEmail = votedEmail;     }
    public void setEventId(Long eventId)            { this.eventId = eventId;           }

}

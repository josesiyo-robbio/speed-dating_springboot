package com.josesiyo_robbio.speed_dating.model;

import jakarta.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "events")
public class Event
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int duration;
    private Timestamp dateTime;


    //GETTERS
    public Long     getId()             { return id;        }
    public String   getName()           { return name;      }
    public int      getDuration()       { return duration;  }
    public Timestamp getDateTime()      { return dateTime;  }


    //SETTERS
    public void setId(Long id)                      { this.id = id;                 }
    public void setName(String name)                { this.name = name;             }
    public void setDuration(int duration)           { this.duration = duration;     }
    public void setDateTime(Timestamp dateTime)     { this.dateTime = dateTime;     }

}
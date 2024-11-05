package com.josesiyo_robbio.speed_dating.repository;

import com.josesiyo_robbio.speed_dating.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EventRepository extends JpaRepository<Event, Long>
{

}

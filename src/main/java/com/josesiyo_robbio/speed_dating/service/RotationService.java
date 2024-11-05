package com.josesiyo_robbio.speed_dating.service;

import com.josesiyo_robbio.speed_dating.dto.ParticipantDto;
import com.josesiyo_robbio.speed_dating.model.Participant;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RotationService
{
    public static List<List<Object>> generateRotations(List<ParticipantDto> participants, int duration, Timestamp dateTime) {
        List<Participant> men = new ArrayList<>();
        List<Participant> women = new ArrayList<>();

        // Filtrar participantes por género
        for (ParticipantDto participant : participants)
        {
            if ("male".equals(participant.getGender().toLowerCase()))
            {
                men.add(new Participant(participant.getName(), participant.getGender()));
            } else if ("female".equals(participant.getGender().toLowerCase()))
            {
                women.add(new Participant(participant.getName(), participant.getGender()));
            }
        }

        // Equilibrar los grupos agregando "rest"
        while (men.size() < women.size())
        {
            men.add(new Participant("rest", "male"));
        }
        while (women.size() < men.size())
        {
            women.add(new Participant("rest", "female"));
        }

        int numRounds = men.size(); // o women.size(), ya que son iguales
        List<List<Object>> rotations = new ArrayList<>();
        int roundDuration = duration / numRounds;

        for (int i = 0; i < numRounds; i++)
        {
            List<Object> round = new ArrayList<>();
            for (int j = 0; j < numRounds; j++)
            {
                Map<String, String> pair = new HashMap<>();
                pair.put("man", men.get(j).getName());
                pair.put("woman", women.get((j + i) % numRounds).getName());
                round.add(pair);
            }

            // Calcular el inicio de la ronda utilizando Timestamp
            Timestamp roundStartTime = new Timestamp(dateTime.getTime() + i * roundDuration * 60000);
            round.add(roundStartTime.toString());
            rotations.add(round);
        }
        return rotations;
    }
}
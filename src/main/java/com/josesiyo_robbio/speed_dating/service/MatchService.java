package com.josesiyo_robbio.speed_dating.service;

import com.josesiyo_robbio.speed_dating.dto.MatchDto;
import com.josesiyo_robbio.speed_dating.repository.VoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;



@Service
public class MatchService
{
    private final VoteRepository voteRepository;


    public MatchService(VoteRepository voteRepository)
    {
        this.voteRepository = voteRepository;
    }


    @Transactional(readOnly = true)
    public List<MatchDto> findMatches(Long eventId)
    {
        List<Object[]> results = voteRepository.findMatchesByEventId(eventId);
        List<MatchDto> matches = new ArrayList<>();

        for (Object[] result : results)
        {
            String email1 = (String) result[0];
            String email2 = (String) result[1];
            matches.add(new MatchDto(email1, email2));
        }

        return matches;
    }

}

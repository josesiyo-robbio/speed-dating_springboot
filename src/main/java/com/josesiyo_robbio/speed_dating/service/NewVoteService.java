package com.josesiyo_robbio.speed_dating.service;

import com.josesiyo_robbio.speed_dating.dto.VoteDto;
import com.josesiyo_robbio.speed_dating.model.Vote;
import com.josesiyo_robbio.speed_dating.repository.RegistrationRepository;
import com.josesiyo_robbio.speed_dating.repository.VoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NewVoteService
{
    private static final Logger log = LoggerFactory.getLogger(NewVoteService.class);

    @Autowired
    private VoteRepository  voteRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    public NewVoteService(VoteRepository voteRepository, RegistrationRepository registrationRepository)
    {
        this.voteRepository = voteRepository;
        this.registrationRepository = registrationRepository;
    }

    @Transactional
    public VoteDto newVoting(VoteDto voteDto)
    {
        // Verify that both the voter and the voted are registered at the event
        if (!registrationRepository.existsByEventIdAndParticipantEmail(voteDto.getEventId(), voteDto.getVoterEmail()))
        {
            log.warn("Voter not registered in event: " + voteDto.getVoterEmail());
            throw new IllegalArgumentException("Voter not registered in the event");
        }

        if (!registrationRepository.existsByEventIdAndParticipantEmail(voteDto.getEventId(), voteDto.getVotedEmail()))
        {
            log.warn("Voted participant not registered in event: " + voteDto.getVotedEmail());
            throw new IllegalArgumentException("Voted participant not registered in the event");
        }

        // Check if a similar vote already exists to avoid duplicates
        if (voteRepository.existsByVoterEmailAndVotedEmailAndEventId(voteDto.getVoterEmail(), voteDto.getVotedEmail(), voteDto.getEventId()))
        {
            log.warn("Duplicate vote attempt by " + voteDto.getVoterEmail() + " for " + voteDto.getVotedEmail());
            throw new IllegalStateException("Duplicate vote is not allowed");
        }

        // Save the new vote
        Vote newVote = new Vote();
        newVote.setVoterEmail(voteDto.getVoterEmail());
        newVote.setVotedEmail(voteDto.getVotedEmail());
        newVote.setEventId(voteDto.getEventId());
        voteRepository.save(newVote);

        log.info("Vote recorded successfully: Voter=" + voteDto.getVoterEmail() + ", Voted=" + voteDto.getVotedEmail());

        voteDto.setMessage("Vote recorded successfully");

        return voteDto;
    }

}

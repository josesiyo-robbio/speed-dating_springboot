package com.josesiyo_robbio.speed_dating.controller;

import com.josesiyo_robbio.speed_dating.dto.VoteDto;
import com.josesiyo_robbio.speed_dating.request.NewVoteRequest;
import com.josesiyo_robbio.speed_dating.response.NewVoteResponse;
import com.josesiyo_robbio.speed_dating.service.NewVoteService;
import com.josesiyo_robbio.speed_dating.service.JwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/votes")
public class NewVoteController
{
    @Value("${jwt.secret}")
    private String secretKey;

    @Autowired
    private NewVoteService newVoteService;

    @Autowired
    private JwtService jwtService;


    @PostMapping
    public ResponseEntity<NewVoteResponse> createVote(@Valid @RequestBody NewVoteRequest voteRequest, @RequestHeader("Authorization") String authorizationHeader)
    {
        String token = authorizationHeader.replace("Bearer ", "");

        String emailFromToken = jwtService.extractClaim(token, claims -> claims.get("email", String.class));
        Long eventIdFromToken = jwtService.extractClaim(token, claims -> claims.get("event_id", Long.class));

        VoteDto voteDto = new VoteDto();
        voteDto.setVoterEmail(emailFromToken);
        voteDto.setVotedEmail(voteRequest.getVotedEmail());
        voteDto.setEventId(eventIdFromToken);

        newVoteService.newVoting(voteDto);

        NewVoteResponse response = new NewVoteResponse("");
        response.setMessage("Vote submitted successfully.");

        return ResponseEntity.ok(response);
    }

}

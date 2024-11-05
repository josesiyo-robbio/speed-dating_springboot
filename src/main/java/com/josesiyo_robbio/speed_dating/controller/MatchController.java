package com.josesiyo_robbio.speed_dating.controller;

import com.josesiyo_robbio.speed_dating.dto.MatchDto;
import com.josesiyo_robbio.speed_dating.request.MatchRequest;
import com.josesiyo_robbio.speed_dating.response.MatchResponse;
import com.josesiyo_robbio.speed_dating.service.MatchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping
    public ResponseEntity<MatchResponse> getMatches(@Valid @RequestBody MatchRequest matchRequest) {
        List<MatchDto> matches = matchService.findMatches(matchRequest.getEventId());
        MatchResponse response = new MatchResponse(matches);
        return ResponseEntity.ok(response);
    }
}

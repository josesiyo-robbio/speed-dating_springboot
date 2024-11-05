package com.josesiyo_robbio.speed_dating.response;

import com.josesiyo_robbio.speed_dating.dto.MatchDto;

import java.util.List;

public class MatchResponse {
    private List<MatchDto> matches;

    public MatchResponse(List<MatchDto> matches) {
        this.matches = matches;
    }

    public List<MatchDto> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchDto> matches) {
        this.matches = matches;
    }
}
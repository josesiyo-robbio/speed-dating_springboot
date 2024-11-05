package com.josesiyo_robbio.speed_dating.dto;

import jakarta.validation.constraints.Email;

public class MatchDto {
    private String participant1;
    private String participant2;

    public MatchDto(String participant1, String participant2) {
        this.participant1 = participant1;
        this.participant2 = participant2;
    }

    public String getParticipant1() {
        return participant1;
    }

    public String getParticipant2() {
        return participant2;
    }
}
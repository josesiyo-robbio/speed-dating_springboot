package com.josesiyo_robbio.speed_dating.controller;

import com.josesiyo_robbio.speed_dating.dto.VoteDto;
import com.josesiyo_robbio.speed_dating.request.NewVoteRequest;
import com.josesiyo_robbio.speed_dating.response.NewVoteResponse;
import com.josesiyo_robbio.speed_dating.service.NewVoteService;
import com.josesiyo_robbio.speed_dating.service.JwtService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;

@RestController
@RequestMapping("/api/votes")
public class NewVoteController {
    @Value("${jwt.secret}") // Asegúrate de que esto coincida con la clave en tu archivo de propiedades
    private String secretKey;

    @Autowired
    private NewVoteService newVoteService;

    @Autowired
    private JwtService jwtService;

    @PostMapping
    public ResponseEntity<NewVoteResponse> createVote(
            @RequestBody NewVoteRequest voteRequest,
            @RequestHeader("Authorization") String authorizationHeader) {

        // Extraer información del token
        String token = authorizationHeader.replace("Bearer ", "");

        // Aquí deberías validar y extraer la información del token
        String emailFromToken = jwtService.extractClaim(token, claims -> claims.get("email", String.class));
        Long eventIdFromToken = jwtService.extractClaim(token, claims -> claims.get("event_id", Long.class));

        // Crear el objeto VoteDto usando los datos del request
        VoteDto voteDto = new VoteDto();
        voteDto.setVoterEmail(emailFromToken);
        voteDto.setVotedEmail(voteRequest.getVotedEmail());
        voteDto.setEventId(eventIdFromToken);

        // Llamar al servicio para procesar el voto
        newVoteService.newVoting(voteDto);

        // Crear la respuesta
        NewVoteResponse response = new NewVoteResponse("");
        response.setMessage("Vote submitted successfully.");

        return ResponseEntity.ok(response);
    }


}

package com.josesiyo_robbio.speed_dating.repository;

import com.josesiyo_robbio.speed_dating.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long>
{

    @Query(value = """
            SELECT
                LEAST(v1.voter_email, v1.voted_email) AS email1,
                GREATEST(v1.voter_email, v1.voted_email) AS email2
            FROM
                votes v1
            JOIN
                votes v2 ON v1.voter_email = v2.voted_email AND v1.voted_email = v2.voter_email
            WHERE
                v1.event_id = :eventId
            GROUP BY
                email1, email2
            """, nativeQuery = true)
    List<Object[]> findMatchesByEventId(@Param("eventId") Long eventId);

    boolean existsByVoterEmailAndVotedEmailAndEventId(String voterEmail, String votedEmail, Long eventId);
}



package co.joebirch.bastion.domain.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import co.joebirch.bastion.domain.util.TestDataFactory;

import static junit.framework.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MatchTest {

    @Test
    public void buildMatch() {
        Match match = TestDataFactory.makeMatch();

        Match.Builder matchBuilder = new Match.Builder()
                .setMatchFormat(match.matchFormat)
                .setDate(match.date)
                .setDiscipline(match.discipline)
                .setGroupNumber(match.groupNumber)
                .setId(match.id)
                .setNumber(match.number)
                .setOpponents(match.opponents)
                .setPending(match.pending)
                .setRoundNumber(match.roundNumber)
                .setStageNumber(match.stageNumber)
                .setStatus(match.status)
                .setType(match.type)
                .setTimezone(match.timezone)
                .setTournamentId(match.tournamentId)
                .setGroupNumber(match.groupNumber);

        assertEquals(match, matchBuilder.build());
    }

}
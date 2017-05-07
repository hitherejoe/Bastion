package co.joebirch.bastion.domain.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import co.joebirch.bastion.domain.util.TestDataFactory;

import static junit.framework.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TournamentTest {

    @Test
    public void buildTournament() {
        Tournament tournament = TestDataFactory.makeTournament();

        Tournament.Builder tournamentBuilder = new Tournament.Builder()
                .setDateEnd(tournament.dateEnd)
                .setDateStart(tournament.dateStart)
                .setId(tournament.id)
                .setName(tournament.name)
                .setSize(tournament.size)
                .setStatus(tournament.status);

        assertEquals(tournament, tournamentBuilder.build());
    }

}
package co.joebirch.bastion.domain.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import co.joebirch.bastion.domain.util.TestDataFactory;

import static junit.framework.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FullTournamentTest {

    @Test
    public void buildFullTournament() {
        FullTournament fullTournament =
                TestDataFactory.makeFullTournament();

        FullTournament.Builder fullTournamentBuilder = new FullTournament.Builder()
                .setCountry(fullTournament.country)
                .setDateEnd(fullTournament.dateEnd)
                .setDateStart(fullTournament.dateStart)
                .setDescription(fullTournament.description)
                .setId(fullTournament.id)
                .setLocation(fullTournament.location)
                .setMatchType(fullTournament.matchType)
                .setName(fullTournament.name)
                .setOrganization(fullTournament.organization)
                .setParticipantType(fullTournament.participantType)
                .setPrize(fullTournament.prize)
                .setRules(fullTournament.rules)
                .setSize(fullTournament.size)
                .setStatus(fullTournament.status)
                .setStreams(fullTournament.streams)
                .setTimezone(fullTournament.timezone)
                .setWebsite(fullTournament.website)
                .setStreams(fullTournament.streams);

        assertEquals(fullTournament, fullTournamentBuilder.build());
    }

}

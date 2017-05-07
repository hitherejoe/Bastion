package co.joebirch.bastion.domain.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import co.joebirch.bastion.domain.util.TestDataFactory;

import static junit.framework.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ParticipantTest {

    @Test
    public void buildParticipant() {
        Participant participant = TestDataFactory.makeParticipant();

        Participant.Builder participantBuilder = new Participant.Builder()
                .setCountry(participant.country)
                .setId(participant.id)
                .setName(participant.name);

        assertEquals(participant, participantBuilder.build());
    }

}
package co.joebirch.bastion.domain.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import co.joebirch.bastion.domain.util.TestDataFactory;

import static junit.framework.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class OpponentTest {

    @Test
    public void buildOpponent() {
        Opponent opponent = TestDataFactory.makeOpponent();

        Opponent.Builder matchBuilder = new Opponent.Builder()
                .setNumber(opponent.number)
                .setForfeit(opponent.forfeit)
                .setParticipant(opponent.participant)
                .setResult(opponent.result)
                .setScore(opponent.score);

        assertEquals(opponent, matchBuilder.build());
    }

}
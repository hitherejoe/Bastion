package co.joebirch.bastion.domain.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import co.joebirch.bastion.domain.util.TestDataFactory;

import static junit.framework.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    @Test
    public void buildGame() {
        Game gameModel = TestDataFactory.makeGame();
        Opponent[] opponents = TestDataFactory.makeOpponentsArray(2);
        Game game = TestDataFactory.makeGame();
        game.opponents = opponents;
        game.number = gameModel.number;
        game.status = gameModel.status;

        Game.Builder gameBuilder = new Game.Builder()
                .setNumber(game.number)
                .setStatus(game.status)
                .setOpponents(game.opponents);

        assertEquals(game, gameBuilder.build());
    }

}

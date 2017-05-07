package co.joebirch.bastion.domain.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.joebirch.bastion.domain.model.FullTournament;
import co.joebirch.bastion.domain.model.Game;
import co.joebirch.bastion.domain.model.Match;
import co.joebirch.bastion.domain.model.Opponent;
import co.joebirch.bastion.domain.model.Participant;
import co.joebirch.bastion.domain.model.Stage;
import co.joebirch.bastion.domain.model.Stream;
import co.joebirch.bastion.domain.model.Tournament;

public class TestDataFactory {

    private static final Random sRandom = new Random();

    public static String randomUuid() {
        return UUID.randomUUID().toString();
    }

    public static boolean randomBoolen() {
        return sRandom.nextBoolean();
    }

    private static int randomInt() {
        return sRandom.nextInt(200) + Integer.SIZE - 1;
    }

    public static Tournament makeTournament() {
        Tournament tournament = new Tournament();
        tournament.id = randomUuid();
        tournament.name = randomUuid();
        tournament.status = randomUuid();
        tournament.dateEnd = new Date().toString();
        tournament.dateStart = new Date().toString();
        tournament.size = randomInt();
        return tournament;
    }

    public static FullTournament makeFullTournament() {
        FullTournament fullTournament = new FullTournament();
        fullTournament.id = randomUuid();
        fullTournament.name = randomUuid();
        fullTournament.status = randomUuid();
        fullTournament.dateEnd = new Date().toString();
        fullTournament.dateStart = new Date().toString();
        fullTournament.size = randomInt();
        fullTournament.timezone = randomUuid();
        fullTournament.location = randomUuid();
        fullTournament.country = randomUuid();
        fullTournament.participantType = randomUuid();
        fullTournament.matchType = randomUuid();
        fullTournament.organization = randomUuid();
        fullTournament.website = randomUuid();
        fullTournament.description = randomUuid();
        fullTournament.rules = randomUuid();
        fullTournament.prize = randomUuid();
        fullTournament.streams = makeStreamArray(2);
        return fullTournament;
    }

    public static Stream[] makeStreamArray(int count) {
        Stream[] streams = new Stream[count];
        for (int i = 0; i < count; i++) {
            streams[i] = makeStream();
        }
        return streams;
    }

    public static Stream makeStream() {
        Stream stream = new Stream();
        stream.id = randomUuid();
        stream.name = randomUuid();
        stream.url = randomUuid();
        return stream;
    }

    public static Match makeMatch() {
        Match match = new Match();
        match.id = randomUuid();
        match.date = new Date().toString();
        match.number = randomInt();
        match.groupNumber = randomInt();
        match.discipline = randomUuid();
        match.status = randomUuid();
        match.pending = randomUuid();
        match.tournamentId = randomUuid();
        match.stageNumber = randomInt();
        match.roundNumber = randomInt();
        match.date = randomUuid();
        match.timezone = randomUuid();
        match.matchFormat = randomUuid();
        match.opponents = makeOpponentsArray(2);
        return match;
    }

    public static Stage makeStage() {
        Stage stage = new Stage();
        stage.name = randomUuid();
        stage.number = randomInt();
        stage.size = randomInt();
        stage.type = randomUuid();
        return stage;
    }

    public static Participant makeParticipant() {
        Participant participant = new Participant();
        participant.country = randomUuid();
        participant.name = randomUuid();
        participant.id = randomUuid();
        return participant;
    }

    public static Opponent makeOpponent() {
        Opponent opponent = new Opponent();
        opponent.forfeit = randomBoolen();
        opponent.number = randomInt();
        opponent.score = randomUuid();
        opponent.result = randomInt();
        opponent.participant = makeParticipant();
        return opponent;
    }

    public static Opponent[] makeOpponentsArray(int count) {
        Opponent[] opponentModels = new Opponent[count];
        for (int i = 0; i < count; i++) {
            opponentModels[i] = makeOpponent();
        }
        return opponentModels;
    }

    public static Game makeGame() {
        Game game = new Game();
        game.number = randomInt();
        game.opponents = makeOpponentsArray(3);
        game.status= randomUuid();
        return game;
    }

    public static List<Game> makeGameList(int count) {
        List<Game> gameModels = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            gameModels.add(makeGame());
        }
        return gameModels;
    }

}

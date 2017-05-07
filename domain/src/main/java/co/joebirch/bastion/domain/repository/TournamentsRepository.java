package co.joebirch.bastion.domain.repository;

import java.util.List;

import co.joebirch.bastion.domain.model.FullTournament;
import co.joebirch.bastion.domain.model.Game;
import co.joebirch.bastion.domain.model.Match;
import co.joebirch.bastion.domain.model.Participant;
import co.joebirch.bastion.domain.model.Stage;
import co.joebirch.bastion.domain.model.Tournament;
import io.reactivex.Single;

public interface TournamentsRepository {

    /**
     * Get an {@link Single} which will emit a {@link List} of {@link Tournament} instances.
     */
    Single<List<Tournament>> getTournaments();

    /**
     * Get an {@link Single} which will emit a {@link FullTournament} instances.
     */
    Single<FullTournament> getTournament();

    /**
     * Get an {@link Single} which will emit a {@link List} of {@link Match} instances.
     */
    Single<List<Match>> getMatches();

    /**
     * Get an {@link Single} which will emit a {@link List} of {@link Game} instances.
     */
    Single<List<Game>> getGames(String tournamentId, String matchId);

    /**
     * Get an {@link Single} which will emit a {@link List} of {@link Participant} instances.
     */
    Single<List<Participant>> getParticipants();

    /**
     * Get an {@link Single} which will emit a {@link List} of {@link Stage} instances.
     */
    Single<List<Stage>> getStages();

}
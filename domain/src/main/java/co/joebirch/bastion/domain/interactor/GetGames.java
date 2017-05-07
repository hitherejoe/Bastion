package co.joebirch.bastion.domain.interactor;

import java.util.List;

import javax.inject.Inject;

import co.joebirch.bastion.domain.executor.PostExecutionThread;
import co.joebirch.bastion.domain.executor.ThreadExecutor;
import co.joebirch.bastion.domain.model.Game;
import co.joebirch.bastion.domain.repository.TournamentsRepository;
import io.reactivex.Single;

public class GetGames extends UseCase<List<Game>, GetGames.Params> {

    private final TournamentsRepository tournamentsRepository;

    @Inject
    GetGames(TournamentsRepository tournamentsRepository,
             ThreadExecutor threadExecutor,
             PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.tournamentsRepository = tournamentsRepository;
    }

    @Override
    public Single<List<Game>> buildUseCaseObservable(Params params) {
        return tournamentsRepository.getGames(params.tournamentId, params.matchId);
    }

    public static final class Params {

        private final String tournamentId;
        private final String matchId;

        private Params(String tournamentId, String matchId) {
            this.tournamentId = tournamentId;
            this.matchId = matchId;
        }

        public static Params forMatch(String tournamentId, String matchId) {
            return new Params(tournamentId, matchId);
        }
    }

}
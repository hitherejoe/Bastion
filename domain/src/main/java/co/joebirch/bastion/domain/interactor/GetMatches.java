package co.joebirch.bastion.domain.interactor;

import java.util.List;

import javax.inject.Inject;

import co.joebirch.bastion.domain.executor.PostExecutionThread;
import co.joebirch.bastion.domain.executor.ThreadExecutor;
import co.joebirch.bastion.domain.model.Match;
import co.joebirch.bastion.domain.repository.TournamentsRepository;
import io.reactivex.Single;

public class GetMatches extends UseCase<List<Match>, Void> {

    private final TournamentsRepository tournamentsRepository;

    @Inject
    GetMatches(TournamentsRepository tournamentsRepository,
               ThreadExecutor threadExecutor,
               PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.tournamentsRepository = tournamentsRepository;
    }

    @Override
    public Single<List<Match>> buildUseCaseObservable(Void unused) {
        return tournamentsRepository.getMatches();
    }

}

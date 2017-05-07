package co.joebirch.bastion.domain.interactor;

import java.util.List;

import javax.inject.Inject;

import co.joebirch.bastion.domain.executor.PostExecutionThread;
import co.joebirch.bastion.domain.executor.ThreadExecutor;
import co.joebirch.bastion.domain.model.Tournament;
import co.joebirch.bastion.domain.repository.TournamentsRepository;
import io.reactivex.Single;

public class GetTournaments extends UseCase<List<Tournament>, Void> {

    private final TournamentsRepository tournamentsRepository;

    @Inject
    GetTournaments(TournamentsRepository tournamentsRepository,
                   ThreadExecutor threadExecutor,
                   PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.tournamentsRepository = tournamentsRepository;
    }

    @Override
    public Single<List<Tournament>> buildUseCaseObservable(Void unused) {
        return tournamentsRepository.getTournaments();
    }

}

package co.joebirch.bastion.domain.interactor;

import javax.inject.Inject;

import co.joebirch.bastion.domain.executor.PostExecutionThread;
import co.joebirch.bastion.domain.executor.ThreadExecutor;
import co.joebirch.bastion.domain.model.FullTournament;
import co.joebirch.bastion.domain.repository.TournamentsRepository;
import io.reactivex.Single;

public class GetTournament extends UseCase<FullTournament, Void> {

    private final TournamentsRepository tournamentsRepository;

    @Inject
    GetTournament(TournamentsRepository tournamentsRepository,
                  ThreadExecutor threadExecutor,
                  PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.tournamentsRepository = tournamentsRepository;
    }

    @Override
    public Single<FullTournament> buildUseCaseObservable(Void unused) {
        return tournamentsRepository.getTournament();
    }

}

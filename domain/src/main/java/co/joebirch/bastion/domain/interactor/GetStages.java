package co.joebirch.bastion.domain.interactor;

import java.util.List;

import javax.inject.Inject;

import co.joebirch.bastion.domain.executor.PostExecutionThread;
import co.joebirch.bastion.domain.executor.ThreadExecutor;
import co.joebirch.bastion.domain.model.Stage;
import co.joebirch.bastion.domain.repository.TournamentsRepository;
import io.reactivex.Single;

public class GetStages extends UseCase<List<Stage>, Void> {

    private final TournamentsRepository tournamentsRepository;

    @Inject
    GetStages(TournamentsRepository tournamentsRepository,
              ThreadExecutor threadExecutor,
              PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.tournamentsRepository = tournamentsRepository;
    }

    @Override
    public Single<List<Stage>> buildUseCaseObservable(Void unused) {
        return tournamentsRepository.getStages();
    }

}

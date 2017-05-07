package co.joebirch.bastion.domain.interactor;

import java.util.List;

import javax.inject.Inject;

import co.joebirch.bastion.domain.executor.PostExecutionThread;
import co.joebirch.bastion.domain.executor.ThreadExecutor;
import co.joebirch.bastion.domain.model.Participant;
import co.joebirch.bastion.domain.repository.TournamentsRepository;
import io.reactivex.Single;

public class GetParticipants extends UseCase<List<Participant>, Void> {

    private final TournamentsRepository tournamentsRepository;

    @Inject
    GetParticipants(TournamentsRepository tournamentsRepository,
                    ThreadExecutor threadExecutor,
                    PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.tournamentsRepository = tournamentsRepository;
    }

    @Override
    public Single<List<Participant>> buildUseCaseObservable(Void unused) {
        return tournamentsRepository.getParticipants();
    }

}

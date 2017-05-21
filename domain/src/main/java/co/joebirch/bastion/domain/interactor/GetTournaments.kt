package co.joebirch.bastion.domain.interactor

import co.joebirch.bastion.domain.executor.PostExecutionThread
import co.joebirch.bastion.domain.executor.ThreadExecutor
import co.joebirch.bastion.domain.model.Tournament
import co.joebirch.bastion.domain.repository.TournamentsRepository
import io.reactivex.Single
import javax.inject.Inject

class GetTournaments @Inject constructor(private val tournamentsRepository: TournamentsRepository,
                     postExecutionThread: PostExecutionThread,
                     threadExecutor: ThreadExecutor)
    : UseCase<List<Tournament>, Void>(postExecutionThread, threadExecutor) {

    override fun buildUseCaseObservable(params: Void?): Single<List<Tournament>> {
        return tournamentsRepository.getTournaments()
    }

}
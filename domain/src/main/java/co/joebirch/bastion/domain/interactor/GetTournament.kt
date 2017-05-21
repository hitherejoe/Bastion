package co.joebirch.bastion.domain.interactor

import co.joebirch.bastion.domain.executor.PostExecutionThread
import co.joebirch.bastion.domain.executor.ThreadExecutor
import co.joebirch.bastion.domain.model.FullTournament
import co.joebirch.bastion.domain.repository.TournamentsRepository
import io.reactivex.Single
import javax.inject.Inject

class GetTournament @Inject constructor(private val tournamentsRepository: TournamentsRepository,
                                        postExecutionThread: PostExecutionThread,
                                        threadExecutor: ThreadExecutor)
    : UseCase<FullTournament, Void>(postExecutionThread, threadExecutor) {

    override fun buildUseCaseObservable(params: Void?): Single<FullTournament> {
        return tournamentsRepository.getTournament()
    }

}
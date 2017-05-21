package co.joebirch.bastion.domain.interactor

import co.joebirch.bastion.domain.executor.PostExecutionThread
import co.joebirch.bastion.domain.executor.ThreadExecutor
import co.joebirch.bastion.domain.model.Match
import co.joebirch.bastion.domain.repository.TournamentsRepository
import io.reactivex.Single
import javax.inject.Inject

class GetMatches @Inject constructor(private val tournamentsRepository: TournamentsRepository,
                                        postExecutionThread: PostExecutionThread,
                                        threadExecutor: ThreadExecutor)
    : UseCase<List<Match>, Void>(postExecutionThread, threadExecutor) {

    override fun buildUseCaseObservable(params: Void?): Single<List<Match>> {
        return tournamentsRepository.getMatches()
    }
    
}
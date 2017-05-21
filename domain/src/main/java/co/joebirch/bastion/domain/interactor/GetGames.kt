package co.joebirch.bastion.domain.interactor

import co.joebirch.bastion.domain.executor.PostExecutionThread
import co.joebirch.bastion.domain.executor.ThreadExecutor
import co.joebirch.bastion.domain.model.Game
import co.joebirch.bastion.domain.repository.TournamentsRepository
import io.reactivex.Single
import javax.inject.Inject

class GetGames @Inject constructor(private val tournamentsRepository: TournamentsRepository,
                                        postExecutionThread: PostExecutionThread,
                                        threadExecutor: ThreadExecutor)
    : UseCase<List<Game>, GetGames.Params>(postExecutionThread, threadExecutor) {

    override fun buildUseCaseObservable(params: Params?): Single<List<Game>> {
        return tournamentsRepository.getGames(params?.tournamentId, params?.matchId)
    }

    class Params constructor(val tournamentId: String,
                             val matchId: String) {
        companion object {
            fun forMatch(tournamentId: String, matchId: String): Params {
                return Params(tournamentId, matchId)
            }
        }
    }
    
}
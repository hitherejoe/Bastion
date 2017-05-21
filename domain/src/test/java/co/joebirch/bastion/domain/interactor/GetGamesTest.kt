package co.joebirch.bastion.domain.interactor

import co.joebirch.bastion.domain.executor.PostExecutionThread
import co.joebirch.bastion.domain.executor.ThreadExecutor
import co.joebirch.bastion.domain.model.Game
import co.joebirch.bastion.domain.repository.TournamentsRepository
import co.joebirch.bastion.domain.util.TestDataFactory
import com.nhaarman.mockito_kotlin.*
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.mockito.ArgumentMatchers.anyString

class GetGamesTest {

    private lateinit var getGames: GetGames

    private var mockThreadExecutor: ThreadExecutor = mock()
    private var mockPostExecutionThread: PostExecutionThread = mock()
    private var mockTournamentsRepository: TournamentsRepository = mock()

    @Before
    fun setUp() {
        getGames = GetGames(mockTournamentsRepository, mockPostExecutionThread, mockThreadExecutor)
    }

    @org.junit.Test
    fun testGetTournamentsUseCaseObservableSucceeds() {
        stubTournamentsRepositoryGetGames()
        val tournamentId = TestDataFactory.randomUuid()
        val matchId = TestDataFactory.randomUuid()
        getGames.buildUseCaseObservable(GetGames.Params.forMatch(tournamentId, matchId))

        verify(mockTournamentsRepository).getGames(tournamentId, matchId)
        verifyNoMoreInteractions(mockTournamentsRepository)
        verifyZeroInteractions(mockThreadExecutor)
        verifyZeroInteractions(mockPostExecutionThread)
    }

    @org.junit.Test
    fun testGetTournamentsUsecaseIsCalledOnce() {
        stubTournamentsRepositoryGetGames()
        stubPostExecutionThreadGetScheduler()
        val tournamentId = TestDataFactory.randomUuid()
        val matchId = TestDataFactory.randomUuid()
        getGames.execute(GetGames.Params.forMatch(tournamentId, matchId))

        verify(mockTournamentsRepository).getGames(tournamentId, matchId)
    }

    private fun stubTournamentsRepositoryGetGames() {
        whenever(mockTournamentsRepository.getGames(anyString(), anyString()))
                .thenReturn(createGetGamesObservable())
    }

    private fun stubPostExecutionThreadGetScheduler() {
        whenever(mockPostExecutionThread.getScheduler())
                .thenReturn(Schedulers.trampoline())
    }

    private fun createGetGamesObservable(): Single<List<Game>> {
        return Single.just<List<Game>>(TestDataFactory.makeGameList(5))
    }

}
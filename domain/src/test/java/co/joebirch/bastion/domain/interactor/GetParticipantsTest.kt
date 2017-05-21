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

class GetParticipantsTest {

    private lateinit var getParticipants: GetParticipants

    private var mockThreadExecutor: ThreadExecutor = mock()
    private var mockPostExecutionThread: PostExecutionThread = mock()
    private var mockTournamentsRepository: TournamentsRepository = mock()

    @Before
    fun setUp() {
        getParticipants = GetParticipants(mockTournamentsRepository, mockPostExecutionThread,
                mockThreadExecutor)
    }

    @org.junit.Test
    fun testGetTournamentsUseCaseObservableSucceeds() {
        stubTournamentsRepositoryGetGames()
        getParticipants.buildUseCaseObservable(null)

        verify(mockTournamentsRepository).getParticipants()
        verifyNoMoreInteractions(mockTournamentsRepository)
        verifyZeroInteractions(mockThreadExecutor)
        verifyZeroInteractions(mockPostExecutionThread)
    }

    @org.junit.Test
    @Throws(Exception::class)
    fun testGetTournamentsUsecaseIsCalledOnce() {
        stubTournamentsRepositoryGetGames()
        stubPostExecutionThreadGetScheduler()
        getParticipants.buildUseCaseObservable(null)

        verify(mockTournamentsRepository).getParticipants()
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
        return Single.just(TestDataFactory.makeGameList(5))
    }

}
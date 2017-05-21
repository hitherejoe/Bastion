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
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString

class GetStagesTest {

    private lateinit var getStages: GetStages

    private var mockThreadExecutor: ThreadExecutor = mock()
    private var mockPostExecutionThread: PostExecutionThread = mock()
    private var mockTournamentsRepository: TournamentsRepository = mock()

    @Before
    fun setUp() {
        org.mockito.MockitoAnnotations.initMocks(this)
        getStages = GetStages(mockTournamentsRepository, mockPostExecutionThread,
                mockThreadExecutor)
    }

    @Test
    fun testGetTournamentsUseCaseObservableSucceeds() {
        stubTournamentsRepositoryGetGames()
        getStages.buildUseCaseObservable(null)

        verify(mockTournamentsRepository).getStages()
        verifyNoMoreInteractions(mockTournamentsRepository)
        verifyZeroInteractions(mockThreadExecutor)
        verifyZeroInteractions(mockPostExecutionThread)
    }

    @Test
    @Throws(Exception::class)
    fun testGetTournamentsUsecaseIsCalledOnce() {
        stubTournamentsRepositoryGetGames()
        stubPostExecutionThreadGetScheduler()
        getStages.buildUseCaseObservable(null)

        verify(mockTournamentsRepository).getStages()
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
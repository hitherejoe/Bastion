package co.joebirch.bastion.domain.interactor

import co.joebirch.bastion.domain.executor.PostExecutionThread
import co.joebirch.bastion.domain.executor.ThreadExecutor
import co.joebirch.bastion.domain.model.Match
import co.joebirch.bastion.domain.repository.TournamentsRepository
import co.joebirch.bastion.domain.util.TestDataFactory
import com.nhaarman.mockito_kotlin.*
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test

class GetMatchesTest {

    private lateinit var getMatches: GetMatches

    private var mockThreadExecutor: ThreadExecutor = mock()
    private var mockPostExecutionThread: PostExecutionThread = mock()
    private var mockTournamentsRepository: TournamentsRepository = mock()

    @Before
    fun setUp() {
        org.mockito.MockitoAnnotations.initMocks(this)
        getMatches = GetMatches(mockTournamentsRepository, mockPostExecutionThread,
                mockThreadExecutor)
    }

    @Test
    fun testGetTournamentsUseCaseObservableSucceeds() {
        getMatches.buildUseCaseObservable(null)

        verify(mockTournamentsRepository).getMatches()
        verifyNoMoreInteractions(mockTournamentsRepository)
        verifyZeroInteractions(mockThreadExecutor)
        verifyZeroInteractions(mockPostExecutionThread)
    }

    @Test
    fun getTournamentsIsCalledOnce() {
        stubTournamentsRepositoryGetTournaments()
        stubPostExecutionThreadGetScheduler()
        getMatches.execute(null)

        verify(mockTournamentsRepository).getMatches()
    }

    private fun stubTournamentsRepositoryGetTournaments() {
        whenever(mockTournamentsRepository.getMatches())
                .thenReturn(createDisciplineObservable())
    }

    private fun stubPostExecutionThreadGetScheduler() {
        whenever(mockPostExecutionThread.getScheduler())
                .thenReturn(Schedulers.trampoline())
    }

    private fun createDisciplineObservable(): Single<List<Match>> {
        return Single.just(listOf(TestDataFactory.makeMatch()))
    }

}
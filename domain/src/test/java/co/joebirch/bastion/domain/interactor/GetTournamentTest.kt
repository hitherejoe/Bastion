package co.joebirch.bastion.domain.interactor

import co.joebirch.bastion.domain.executor.PostExecutionThread
import co.joebirch.bastion.domain.executor.ThreadExecutor
import co.joebirch.bastion.domain.model.FullTournament
import co.joebirch.bastion.domain.repository.TournamentsRepository
import co.joebirch.bastion.domain.util.TestDataFactory
import com.nhaarman.mockito_kotlin.*
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class GetTournamentTest {

    private lateinit var getTournament: GetTournament

    private var mockThreadExecutor: ThreadExecutor = mock()
    private var mockPostExecutionThread: PostExecutionThread = mock()
    private var mockTournamentsRepository: TournamentsRepository = mock()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getTournament = GetTournament(mockTournamentsRepository, mockPostExecutionThread,
                mockThreadExecutor)
    }

    @Test
    fun testGetTournamentsUseCaseObservableSucceeds() {
        stubTournamentsRepositoryGetDisciplines()
        stubPostExecutionThreadGetScheduler()
        getTournament.buildUseCaseObservable(null)

        verify(mockTournamentsRepository).getTournament()
        verifyNoMoreInteractions(mockTournamentsRepository)
        verifyZeroInteractions(mockThreadExecutor)
    }

    @Test
    fun testGetTournamentsUseCaseIsCalledOnce() {
        stubTournamentsRepositoryGetDisciplines()
        stubPostExecutionThreadGetScheduler()
        getTournament.execute(null)

        verify(mockTournamentsRepository).getTournament()
    }

    private fun stubTournamentsRepositoryGetDisciplines() {
        whenever(mockTournamentsRepository.getTournament())
                .thenReturn(createTournamentObservable())
    }

    private fun stubPostExecutionThreadGetScheduler() {
        whenever(mockPostExecutionThread.getScheduler())
                .thenReturn(Schedulers.trampoline())
    }

    private fun createTournamentObservable(): Single<FullTournament> {
        return Single.just(TestDataFactory.makeFullTournament())
    }

}
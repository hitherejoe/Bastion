package co.joebirch.bastion.domain.interactor

import co.joebirch.bastion.domain.executor.PostExecutionThread
import co.joebirch.bastion.domain.executor.ThreadExecutor
import co.joebirch.bastion.domain.interactor.GetTournaments
import co.joebirch.bastion.domain.model.Tournament
import co.joebirch.bastion.domain.repository.TournamentsRepository
import co.joebirch.bastion.domain.util.TestDataFactory
import com.nhaarman.mockito_kotlin.*
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test

class GetTournamentsTest {

    private lateinit var getTournaments: co.joebirch.bastion.domain.interactor.GetTournaments

    private var mockThreadExecutor: co.joebirch.bastion.domain.executor.ThreadExecutor = com.nhaarman.mockito_kotlin.mock()
    private var mockPostExecutionThread: co.joebirch.bastion.domain.executor.PostExecutionThread = com.nhaarman.mockito_kotlin.mock()
    private var mockTournamentsRepository: co.joebirch.bastion.domain.repository.TournamentsRepository = com.nhaarman.mockito_kotlin.mock()

    @org.junit.Before
    fun setUp() {
        getTournaments = co.joebirch.bastion.domain.interactor.GetTournaments(mockTournamentsRepository,
                mockPostExecutionThread, mockThreadExecutor)
    }

    @org.junit.Test
    fun testGetTournamentsUseCaseObservableSucceeds() {
        getTournaments.buildUseCaseObservable(null)

        com.nhaarman.mockito_kotlin.verify(mockTournamentsRepository).getTournaments()
        com.nhaarman.mockito_kotlin.verifyNoMoreInteractions(mockTournamentsRepository)
        com.nhaarman.mockito_kotlin.verifyZeroInteractions(mockThreadExecutor)
        com.nhaarman.mockito_kotlin.verifyZeroInteractions(mockPostExecutionThread)
    }

    @org.junit.Test
    fun testGetTournamentsUsecaseIsCalledOnce() {
        stubTournamentsRepositoryGetDisciplines()
        stubPostExecutionThreadGetScheduler()
        getTournaments.execute(null)

        com.nhaarman.mockito_kotlin.verify(mockTournamentsRepository).getTournaments()
    }

    private fun stubTournamentsRepositoryGetDisciplines() {
        com.nhaarman.mockito_kotlin.whenever(mockTournamentsRepository.getTournaments())
                .thenReturn(createDisciplineObservable())
    }

    private fun stubPostExecutionThreadGetScheduler() {
        com.nhaarman.mockito_kotlin.whenever(mockPostExecutionThread.getScheduler())
                .thenReturn(io.reactivex.schedulers.Schedulers.trampoline())
    }

    private fun createDisciplineObservable(): io.reactivex.Single<List<Tournament>> {
        return io.reactivex.Single.just(listOf(co.joebirch.bastion.domain.util.TestDataFactory.Factory.makeTournament()))
    }

}
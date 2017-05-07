package co.joebirch.bastion.domain.interactor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import co.joebirch.bastion.domain.executor.PostExecutionThread;
import co.joebirch.bastion.domain.executor.ThreadExecutor;
import co.joebirch.bastion.domain.model.FullTournament;
import co.joebirch.bastion.domain.repository.TournamentsRepository;
import co.joebirch.bastion.domain.util.TestDataFactory;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetTournamentTest {

    private GetTournament getTournament;

    @Mock private ThreadExecutor mockThreadExecutor;
    @Mock private PostExecutionThread mockPostExecutionThread;
    @Mock private TournamentsRepository mockTournamentsRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        getTournament = new GetTournament(mockTournamentsRepository,
                mockThreadExecutor, mockPostExecutionThread);
    }

    @Test
    public void testGetTournamentsUseCaseObservableSucceeds() {
        stubTournamentsRepositoryGetDisciplines();
        stubPostExecutionThreadGetScheduler();
        getTournament.buildUseCaseObservable(null);

        verify(mockTournamentsRepository).getTournament();
        verifyNoMoreInteractions(mockTournamentsRepository);
        verifyZeroInteractions(mockThreadExecutor);
    }

    @Test
    public void testGetTournamentsUseCaseIsCalledOnce() {
        stubTournamentsRepositoryGetDisciplines();
        stubPostExecutionThreadGetScheduler();
        getTournament.execute(null);

        verify(mockTournamentsRepository).getTournament();
    }

    @Test
    public void testGetTournamentsUseCaseImplementsUseCase() {
        assertThat(getTournament, instanceOf(UseCase.class));
    }

    private void stubTournamentsRepositoryGetDisciplines() {
        when(mockTournamentsRepository.getTournament())
                .thenReturn(createTournamentObservable());
    }

    private void stubPostExecutionThreadGetScheduler() {
        when(mockPostExecutionThread.getScheduler())
                .thenReturn(Schedulers.trampoline());
    }

    private Single<FullTournament> createTournamentObservable() {
        return Single.just(TestDataFactory.makeFullTournament());
    }

}
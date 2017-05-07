package co.joebirch.bastion.domain.interactor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import co.joebirch.bastion.domain.executor.PostExecutionThread;
import co.joebirch.bastion.domain.executor.ThreadExecutor;
import co.joebirch.bastion.domain.model.Tournament;
import co.joebirch.bastion.domain.repository.TournamentsRepository;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetTournamentsTest {

    private GetTournaments getTournaments;

    @Mock private ThreadExecutor mockThreadExecutor;
    @Mock private PostExecutionThread mockPostExecutionThread;
    @Mock private TournamentsRepository mockTournamentsRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        getTournaments = new GetTournaments(mockTournamentsRepository,
                mockThreadExecutor, mockPostExecutionThread);
    }

    @Test
    public void testGetTournamentsUseCaseObservableSucceeds() {
        getTournaments.buildUseCaseObservable(null);

        verify(mockTournamentsRepository).getTournaments();
        verifyNoMoreInteractions(mockTournamentsRepository);
        verifyZeroInteractions(mockThreadExecutor);
        verifyZeroInteractions(mockPostExecutionThread);
    }

    @Test
    public void testGetTournamentsUsecaseIsCalledOnce() {
        stubTournamentsRepositoryGetDisciplines();
        stubPostExecutionThreadGetScheduler();
        getTournaments.execute(null);

        verify(mockTournamentsRepository).getTournaments();
    }

    @Test
    public void testGetTournamentsUseCaseImplementsUseCase() {
        assertThat(getTournaments, instanceOf(UseCase.class));
    }

    private void stubTournamentsRepositoryGetDisciplines() {
        when(mockTournamentsRepository.getTournaments())
                .thenReturn(createDisciplineObservable());
    }

    private void stubPostExecutionThreadGetScheduler() {
        when(mockPostExecutionThread.getScheduler())
                .thenReturn(Schedulers.trampoline());
    }

    private Single<List<Tournament>> createDisciplineObservable() {
        return Single.just(Collections.singletonList(new Tournament()));
    }

}

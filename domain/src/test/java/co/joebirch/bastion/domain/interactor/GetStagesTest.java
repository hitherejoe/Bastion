package co.joebirch.bastion.domain.interactor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import co.joebirch.bastion.domain.executor.PostExecutionThread;
import co.joebirch.bastion.domain.executor.ThreadExecutor;
import co.joebirch.bastion.domain.model.Game;
import co.joebirch.bastion.domain.repository.TournamentsRepository;
import co.joebirch.bastion.domain.util.TestDataFactory;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetStagesTest {

    private GetStages getStages;

    @Mock private ThreadExecutor mockThreadExecutor;
    @Mock private PostExecutionThread mockPostExecutionThread;
    @Mock private TournamentsRepository mockTournamentsRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        getStages = new GetStages(mockTournamentsRepository,
                mockThreadExecutor, mockPostExecutionThread);
    }

    @Test
    public void testGetTournamentsUseCaseObservableSucceeds() {
        stubTournamentsRepositoryGetGames();
        getStages.buildUseCaseObservable(null);

        verify(mockTournamentsRepository).getStages();
        verifyNoMoreInteractions(mockTournamentsRepository);
        verifyZeroInteractions(mockThreadExecutor);
        verifyZeroInteractions(mockPostExecutionThread);
    }

    @Test
    public void testGetTournamentsUsecaseIsCalledOnce() throws Exception {
        stubTournamentsRepositoryGetGames();
        stubPostExecutionThreadGetScheduler();
        getStages.buildUseCaseObservable(null);

        verify(mockTournamentsRepository).getStages();
    }

    @Test
    public void testGetGamesUseCaseImplementsUseCase() {
        assertThat(getStages, instanceOf(UseCase.class));
    }

    private void stubTournamentsRepositoryGetGames() {
        when(mockTournamentsRepository.getGames(anyString(), anyString()))
                .thenReturn(createGetGamesObservable());
    }

    private void stubPostExecutionThreadGetScheduler() {
        when(mockPostExecutionThread.getScheduler())
                .thenReturn(Schedulers.trampoline());
    }

    private Single<List<Game>> createGetGamesObservable() {
        return Single.just(TestDataFactory.makeGameList(5));
    }

}

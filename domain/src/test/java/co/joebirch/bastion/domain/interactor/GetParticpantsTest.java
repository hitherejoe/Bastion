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
public class GetParticpantsTest {

    private GetParticipants getParticpants;

    @Mock private ThreadExecutor mockThreadExecutor;
    @Mock private PostExecutionThread mockPostExecutionThread;
    @Mock private TournamentsRepository mockTournamentsRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        getParticpants = new GetParticipants(mockTournamentsRepository,
                mockThreadExecutor, mockPostExecutionThread);
    }

    @Test
    public void testGetTournamentsUseCaseObservableSucceeds() {
        stubTournamentsRepositoryGetGames();
        getParticpants.buildUseCaseObservable(null);

        verify(mockTournamentsRepository).getParticipants();
        verifyNoMoreInteractions(mockTournamentsRepository);
        verifyZeroInteractions(mockThreadExecutor);
        verifyZeroInteractions(mockPostExecutionThread);
    }

    @Test
    public void testGetTournamentsUsecaseIsCalledOnce() throws Exception {
        stubTournamentsRepositoryGetGames();
        stubPostExecutionThreadGetScheduler();
        getParticpants.buildUseCaseObservable(null);

        verify(mockTournamentsRepository).getParticipants();
    }

    @Test
    public void testGetGamesUseCaseImplementsUseCase() {
        assertThat(getParticpants, instanceOf(UseCase.class));
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

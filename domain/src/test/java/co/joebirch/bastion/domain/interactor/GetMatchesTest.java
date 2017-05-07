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
import co.joebirch.bastion.domain.model.Match;
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
public class GetMatchesTest {

    private GetMatches getMatches;

    @Mock private ThreadExecutor mockThreadExecutor;
    @Mock private PostExecutionThread mockPostExecutionThread;
    @Mock private TournamentsRepository mockTournamentsRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        getMatches = new GetMatches(mockTournamentsRepository,
                mockThreadExecutor, mockPostExecutionThread);
    }

    @Test
    public void testGetTournamentsUseCaseObservableSucceeds() {
        getMatches.buildUseCaseObservable(null);

        verify(mockTournamentsRepository).getMatches();
        verifyNoMoreInteractions(mockTournamentsRepository);
        verifyZeroInteractions(mockThreadExecutor);
        verifyZeroInteractions(mockPostExecutionThread);
    }

    @Test
    public void getTournamentsIsCalledOnce() throws Exception {
        stubTournamentsRepositoryGetTournaments();
        stubPostExecutionThreadGetScheduler();
        getMatches.execute(null);

        verify(mockTournamentsRepository).getMatches();
    }

    @Test
    public void getMatchesImplementsUseCase() {
        assertThat(getMatches, instanceOf(UseCase.class));
    }

    private void stubTournamentsRepositoryGetTournaments() {
        when(mockTournamentsRepository.getMatches())
                .thenReturn(createDisciplineObservable());
    }

    private void stubPostExecutionThreadGetScheduler() {
        when(mockPostExecutionThread.getScheduler())
                .thenReturn(Schedulers.trampoline());
    }

    private Single<List<Match>> createDisciplineObservable() {
        return Single.just(Collections.singletonList(new Match()));
    }

}

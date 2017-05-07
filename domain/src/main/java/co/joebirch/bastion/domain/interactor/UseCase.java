package co.joebirch.bastion.domain.interactor;

import co.joebirch.bastion.domain.executor.PostExecutionThread;
import co.joebirch.bastion.domain.executor.ThreadExecutor;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCase<T, Params> {

    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;


    protected UseCase(ThreadExecutor threadExecutor,
                      PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    /**
     * Builds an {@link Single} which will be used when executing the current {@link UseCase}.
     */
    abstract Single<T> buildUseCaseObservable(Params params);

    /**
     * Executes the current use case.
     */
    @SuppressWarnings("unchecked")
    public Single<T> execute(Params params) {
        return this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler());
    }

}
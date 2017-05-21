package co.joebirch.bastion.domain.interactor

import co.joebirch.bastion.domain.executor.PostExecutionThread
import co.joebirch.bastion.domain.executor.ThreadExecutor
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

abstract class UseCase<T, in Params>(private val postExecutionThread: PostExecutionThread,
                                     private val threadExecutor: ThreadExecutor) {

    abstract fun buildUseCaseObservable(params: Params?): Single<T>

    fun execute(params: Params?): Single<T> {
        return buildUseCaseObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
    }

}
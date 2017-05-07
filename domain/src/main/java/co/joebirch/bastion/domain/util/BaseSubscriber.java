package co.joebirch.bastion.domain.util;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * Default subscriber base class to be used whenever you want default error handling.
 */
public abstract class BaseSubscriber<T> implements SingleObserver<T> {

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onSuccess(T value) {

    }

    @Override
    public void onError(Throwable e) {

    }

}
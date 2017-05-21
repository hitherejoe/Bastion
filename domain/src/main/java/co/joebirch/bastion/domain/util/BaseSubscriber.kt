package co.joebirch.bastion.domain.util

import io.reactivex.SingleObserver

abstract class BaseSubscriber<T>: SingleObserver<T>
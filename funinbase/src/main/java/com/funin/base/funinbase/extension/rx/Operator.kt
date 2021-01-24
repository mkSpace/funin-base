package com.funin.base.funinbase.extension.rx

import com.funin.base.funinbase.rx.ErrorLogger
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.BackpressureKind
import io.reactivex.annotations.BackpressureSupport
import io.reactivex.annotations.CheckReturnValue
import io.reactivex.annotations.SchedulerSupport
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy

private val onNextStub: (Any) -> Unit = {}
private val onCompleteStub: () -> Unit = {}

fun <T : Any> Flowable<T>.observeOnMain(): Flowable<T> = observeOn(AndroidSchedulers.mainThread())
fun <T : Any> Single<T>.observeOnMain(): Single<T> = observeOn(AndroidSchedulers.mainThread())
fun <T : Any> Maybe<T>.observeOnMain(): Maybe<T> = observeOn(AndroidSchedulers.mainThread())
fun Completable.observeOnMain(): Completable = observeOn(AndroidSchedulers.mainThread())

@CheckReturnValue
@SchedulerSupport(SchedulerSupport.NONE)
fun <T : Any> Observable<T>.subscribeWithErrorLogger(onNext: (T) -> Unit = onNextStub): Disposable =
    subscribeBy(onNext = onNext, onError = ErrorLogger())

@CheckReturnValue
@BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
@SchedulerSupport(SchedulerSupport.NONE)
fun <T : Any> Flowable<T>.subscribeWithErrorLogger(onNext: (T) -> Unit = onNextStub): Disposable =
    subscribeBy(onNext = onNext, onError = ErrorLogger())

@CheckReturnValue
@SchedulerSupport(SchedulerSupport.NONE)
fun <T : Any> Single<T>.subscribeWithErrorLogger(onSuccess: (T) -> Unit = onNextStub): Disposable =
    subscribeBy(onSuccess = onSuccess, onError = ErrorLogger())

@CheckReturnValue
@SchedulerSupport(SchedulerSupport.NONE)
fun <T : Any> Maybe<T>.subscribeWithErrorLogger(
    onComplete: () -> Unit = onCompleteStub,
    onSuccess: (T) -> Unit = onNextStub
): Disposable = subscribeBy(onSuccess = onSuccess, onComplete = onComplete, onError = ErrorLogger())

@CheckReturnValue
@SchedulerSupport(SchedulerSupport.NONE)
fun Completable.subscribeWithErrorLogger(onComplete: () -> Unit = onCompleteStub): Disposable =
    subscribeBy(onComplete = onComplete, onError = ErrorLogger())

@CheckReturnValue
@SchedulerSupport(SchedulerSupport.NONE)
fun <T : Any> Observable<T>.subscribeWithErrorLogger(
    errorMessage: String = "",
    onNext: (T) -> Unit = onNextStub
): Disposable = subscribeBy(onNext = onNext, onError = ErrorLogger(errorMessage))

@CheckReturnValue
@BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
@SchedulerSupport(SchedulerSupport.NONE)
fun <T : Any> Flowable<T>.subscribeWithErrorLogger(
    errorMessage: String = "",
    onNext: (T) -> Unit = onNextStub
): Disposable = subscribeBy(onNext = onNext, onError = ErrorLogger(errorMessage))

@CheckReturnValue
@SchedulerSupport(SchedulerSupport.NONE)
fun <T : Any> Single<T>.subscribeWithErrorLogger(
    errorMessage: String = "",
    onSuccess: (T) -> Unit = onNextStub
): Disposable = subscribeBy(onSuccess = onSuccess, onError = ErrorLogger(errorMessage))

@CheckReturnValue
@SchedulerSupport(SchedulerSupport.NONE)
fun <T : Any> Maybe<T>.subscribeWithErrorLogger(
    errorMessage: String = "",
    onComplete: () -> Unit = onCompleteStub,
    onSuccess: (T) -> Unit = onNextStub
): Disposable = subscribeBy(
    onSuccess = onSuccess,
    onComplete = onComplete,
    onError = ErrorLogger(errorMessage)
)

@CheckReturnValue
@SchedulerSupport(SchedulerSupport.NONE)
fun Completable.subscribeWithErrorLogger(
    errorMessage: String = "",
    onComplete: () -> Unit = onCompleteStub
): Disposable = subscribeBy(onComplete = onComplete, onError = ErrorLogger(errorMessage))

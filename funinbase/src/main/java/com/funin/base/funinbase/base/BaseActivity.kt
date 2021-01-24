package com.funin.base.funinbase.base

import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo

abstract class BaseActivity : AppCompatActivity() {

    private val disposables by lazy { CompositeDisposable() }

    @CallSuper
    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }

    protected fun Disposable.addToDisposables(): Disposable = addTo(disposables)
}

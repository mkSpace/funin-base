package com.funin.base.funinbase.base

import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo

abstract class BaseFragment : Fragment() {
    private val disposables by lazy { CompositeDisposable() }

    @CallSuper
    override fun onDestroyView() {
        disposables.clear()
        super.onDestroyView()
    }

    protected fun Disposable.addToDisposables(): Disposable = addTo(disposables)
}
package com.funin.base.funinbase.base

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo

abstract class BaseViewModelFragment : Fragment() {

    private val disposables by lazy { CompositeDisposable() }

    @CallSuper
    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onSetupViews(view)
        onBindViewModels()
    }

    open fun onSetupViews(view: View) {}

    open fun onBindViewModels() {}

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        disposables.clear()
    }

    protected fun Disposable.addToDisposables(): Disposable = addTo(disposables)
}

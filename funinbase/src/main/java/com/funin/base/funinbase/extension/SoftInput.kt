package com.funin.base.funinbase.extension

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.fragment.app.Fragment

fun EditText.showSoftInput(): Boolean {
    val inputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            ?: return false

    isFocusable = true
    isFocusableInTouchMode = true
    requestFocus()
    return inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_FORCED)
}

fun View.hideSoftInput(): Boolean {
    val inputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            ?: return false

    isFocusable = true
    isFocusableInTouchMode = true
    requestFocus()
    return inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
}

fun Activity.hideSoftInput(): Boolean {
    val view = currentFocus
        ?: window?.decorView?.rootView
        ?: findViewById<View>(android.R.id.content)
    return view?.hideSoftInput() ?: false
}

fun Fragment.hideSoftInput(): Boolean = activity?.hideSoftInput() ?: false

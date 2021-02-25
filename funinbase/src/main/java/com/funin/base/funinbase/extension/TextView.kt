package com.funin.base.funinbase.extension

import android.graphics.drawable.Drawable
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

fun TextView.setDrawablesWithIntrinsicBounds(
        @DrawableRes left: Int = 0,
        @DrawableRes top: Int = 0,
        @DrawableRes right: Int = 0,
        @DrawableRes bottom: Int = 0
) = setCompoundDrawablesWithIntrinsicBounds(
        if (left != 0) ContextCompat.getDrawable(context, left) else compoundDrawables[0],
        if (top != 0) ContextCompat.getDrawable(context, top) else compoundDrawables[1],
        if (right != 0) ContextCompat.getDrawable(context, right) else compoundDrawables[2],
        if (bottom != 0) ContextCompat.getDrawable(context, bottom) else compoundDrawables[3]
)

fun TextView.setDrawablesWithIntrinsicBounds(
        left: Drawable? = null,
        top: Drawable? = null,
        right: Drawable? = null,
        bottom: Drawable? = null
) = setCompoundDrawablesWithIntrinsicBounds(
        left ?: compoundDrawables[0],
        top ?: compoundDrawables[1],
        right ?: compoundDrawables[2],
        bottom ?: compoundDrawables[3]
)

fun TextView.setDrawablesRelativeWithIntrinsicBounds(
        @DrawableRes start: Int = 0,
        @DrawableRes top: Int = 0,
        @DrawableRes end: Int = 0,
        @DrawableRes bottom: Int = 0
) = setCompoundDrawablesRelativeWithIntrinsicBounds(
        if (start != 0) ContextCompat.getDrawable(context, start) else compoundDrawablesRelative[0],
        if (top != 0) ContextCompat.getDrawable(context, top) else compoundDrawablesRelative[1],
        if (end != 0) ContextCompat.getDrawable(context, end) else compoundDrawablesRelative[2],
        if (bottom != 0) ContextCompat.getDrawable(context, bottom) else compoundDrawablesRelative[3]
)

fun TextView.setDrawablesRelativeWithIntrinsicBounds(
        start: Drawable? = null,
        top: Drawable? = null,
        end: Drawable? = null,
        bottom: Drawable? = null
) = setCompoundDrawablesRelativeWithIntrinsicBounds(
        start ?: compoundDrawablesRelative[0],
        top ?: compoundDrawablesRelative[1],
        end ?: compoundDrawablesRelative[2],
        bottom ?: compoundDrawablesRelative[3]
)

inline var TextView.drawableTop: Drawable
    get() = compoundDrawables[1]
    set(value) {
        setDrawablesWithIntrinsicBounds(top = value)
    }
inline var TextView.drawableBottom: Drawable
    get() = compoundDrawables[3]
    set(value) {
        setDrawablesWithIntrinsicBounds(bottom = value)
    }
inline var TextView.drawableLeft: Drawable
    get() = compoundDrawables[0]
    set(value) {
        setDrawablesWithIntrinsicBounds(left = value)
    }
inline var TextView.drawableRight: Drawable
    get() = compoundDrawables[2]
    set(value) {
        setDrawablesWithIntrinsicBounds(right = value)
    }
inline var TextView.drawableStart: Drawable
    get() = compoundDrawablesRelative[0]
    set(value) {
        setDrawablesRelativeWithIntrinsicBounds(start = value)
    }

inline var TextView.drawableEnd: Drawable
    get() = compoundDrawablesRelative[2]
    set(value) {
        setDrawablesRelativeWithIntrinsicBounds(end = value)
    }

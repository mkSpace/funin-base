package com.funin.base.funinbase.extension

import android.content.Context
import android.util.TypedValue

fun Context.toPixels(value: Number, unit: Int = TypedValue.COMPLEX_UNIT_DIP): Int =
        TypedValue.applyDimension(unit, value.toFloat(), resources.displayMetrics).toInt()

fun Context.toPixelsAsFloat(value: Number, unit: Int = TypedValue.COMPLEX_UNIT_DIP): Float =
        TypedValue.applyDimension(unit, value.toFloat(), resources.displayMetrics)

fun Number.dpToPixels(context: Context): Int = context.toPixels(this)

fun Number.dpToPixelsAsFloat(context: Context): Float = context.toPixelsAsFloat(this)

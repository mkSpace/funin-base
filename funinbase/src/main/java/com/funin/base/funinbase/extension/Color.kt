package com.funin.base.funinbase.extension

import android.graphics.Color
import androidx.annotation.ColorInt

@ColorInt
fun argb(alpha: Int, rgb: Int): Int {
    return alpha shl 24 or (rgb and 0x00ffffff)
}

@ColorInt
fun String.rgba(): Int {
    try {
        checkColorString(this)
    } catch (e: Exception) {
        return Color.TRANSPARENT
    }
    return if (length == 9) {
        val alpha = substring(7, 9).toInt(16)
        val c = Color.parseColor(substring(0, 7))
        argb(alpha, c)
    } else {
        Color.parseColor(this)
    }
}

internal fun checkColorString(color: String) {
    require(!(color.isEmpty() || color[0] != '#')) { "Invalid color format $color" }
}
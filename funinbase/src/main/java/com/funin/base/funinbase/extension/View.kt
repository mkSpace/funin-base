package com.funin.base.funinbase.extension

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.google.android.material.bottomsheet.BottomSheetDialog

fun ViewGroup.inflate(@LayoutRes layoutId: Int, attachToRoot: Boolean = false): View =
        inflate(LayoutInflater.from(context), layoutId, attachToRoot)

fun ViewGroup?.inflate(
        inflater: LayoutInflater,
        @LayoutRes layoutId: Int,
        attachToRoot: Boolean = false
): View = inflater.inflate(layoutId, this, attachToRoot)

fun BottomSheetDialog.show(block: BottomSheetDialog.() -> Unit) {
    block(this)
    show()
}

val View.visibleRectVerticalRatio: Float
    get() {
        val rect = Rect()
        getLocalVisibleRect(rect)
        val heightF = height.toFloat()
        return when {
            rect.top > 0 -> (heightF - rect.top.toFloat()) / heightF
            rect.bottom > 0 && rect.bottom < heightF -> rect.bottom.toFloat() / heightF
            rect.top == 0 && rect.bottom == height -> 1f
            else -> 0f
        }
    }

package com.funin.base.funinbase.extension

import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

fun Fragment.showToast(text: CharSequence, duration: Int = Toast.LENGTH_SHORT) =
        context?.showToast(text, duration)

fun Fragment.showToast(@StringRes textId: Int, duration: Int = Toast.LENGTH_SHORT) =
        context?.showToast(textId, duration)

@ColorInt
fun Fragment.requirePrimaryColor(@ColorInt defaultColor: Int): Int =
        requireContext().getPrimaryColor(defaultColor)

@ColorInt
fun Fragment.requireSecondaryColor(@ColorInt defaultColor: Int): Int =
        requireContext().getSecondaryColor(defaultColor)

fun Fragment.startGalleryIntent(
        tag: String,
        requestCode: Int,
        forceChooser: Boolean = false,
        chooserTitle: String? = null
) {
    context?.startGalleryIntent(
            tag, requestCode, forceChooser, chooserTitle, ::startActivityForResult
    )
}

fun Fragment.startFileBrowserIntent(
        tag: String,
        requestCode: Int,
        forceChooser: Boolean = false,
        title: String? = null
) {
    context?.startFileBrowserIntent(
            tag = tag,
            requestCode = requestCode,
            forceChooser = forceChooser,
            chooserTitle = title,
            startIntent = ::startActivityForResult
    )
}

fun Fragment.startFileViewerIntent(
        tag: String,
        url: String,
        mimeType: String,
        forceChooser: Boolean = false,
        title: String? = null
) {
    context?.startFileViewerIntent(tag, url, mimeType, forceChooser, title, ::startActivity)
}

package com.funin.base.funinbase.extension

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.util.TypedValue
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.StringRes
import androidx.core.content.res.getColorOrThrow
import androidx.core.content.res.use
import androidx.core.os.ConfigurationCompat
import com.funin.base.funinbase.R
import java.util.*

fun Context.showToast(text: CharSequence, duration: Int = Toast.LENGTH_SHORT) =
        Toast.makeText(this, text, duration).show()

fun Context.showToast(@StringRes textId: Int, duration: Int = Toast.LENGTH_SHORT) =
        Toast.makeText(this, textId, duration).show()

@SuppressLint("Recycle")
@ColorInt
fun Context.getPrimaryColor(@ColorInt defaultColor: Int): Int =
        obtainStyledAttributes(TypedValue().data, intArrayOf(R.attr.colorPrimary)).use {
            try {
                it.getColorOrThrow(0)
            } catch (e: IllegalArgumentException) {
                defaultColor
            }
        }

@SuppressLint("Recycle")
@ColorInt
fun Context.getSecondaryColor(@ColorInt defaultColor: Int): Int =
        obtainStyledAttributes(TypedValue().data, intArrayOf(R.attr.colorSecondary)).use {
            try {
                it.getColorOrThrow(0)
            } catch (e: IllegalArgumentException) {
                defaultColor
            }
        }

fun Context.startGalleryIntent(
        tag: String,
        requestCode: Int,
        forceChooser: Boolean = false,
        chooserTitle: String? = null,
        startIntent: (Intent, Int) -> Unit
) {
    val packageManager = packageManager ?: return
    val intent = Intent(Intent.ACTION_PICK).setType("image/*")
    if (intent.resolveActivity(packageManager) != null) {
        startIntent(
                if (forceChooser) Intent.createChooser(intent, chooserTitle) else intent,
                requestCode
        )
    } else {
        Log.e(tag, "Cannot found gallery apps")
    }
}

fun Context.startFileBrowserIntent(
        tag: String,
        requestCode: Int,
        forceChooser: Boolean = false,
        chooserTitle: String? = null,
        startIntent: (Intent, Int) -> Unit
) {
    val packageManager = packageManager ?: return
    val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).setType("*/*")
    if (intent.resolveActivity(packageManager) != null) {
        startIntent(
                if (forceChooser) Intent.createChooser(intent, chooserTitle) else intent,
                requestCode
        )
    } else {
        Log.e(tag, "Cannot found file browser apps")
    }
}

fun Context.startFileViewerIntent(
        tag: String,
        url: String,
        mimeType: String,
        forceChooser: Boolean = false,
        title: String? = null,
        startIntent: (Intent) -> Unit
) {
    val packageManager = packageManager ?: return
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    val componentName = intent.resolveActivity(packageManager)
    if (componentName != null) {
        startIntent(if (forceChooser) Intent.createChooser(intent, title) else intent)
        Log.d(tag, "Open the file($url, $mimeType) in $componentName")
    } else {
        Log.e(tag, "Cannot found apps for the file($url, $mimeType)")
    }
}

val Context?.currentLocale: Locale
    get() = this?.resources?.configuration?.let { ConfigurationCompat.getLocales(it)[0] }
            ?: Locale.getDefault()
package com.funin.base.funinbase.extension

import android.os.Bundle

fun Bundle.getIntOrNull(key: String): Int? = if (containsKey(key)) getInt(key) else null

fun Bundle.getLongOrNull(key: String): Long? = if (containsKey(key)) getLong(key) else null

fun Bundle.getFloatOrNull(key: String): Float? = if (containsKey(key)) getFloat(key) else null

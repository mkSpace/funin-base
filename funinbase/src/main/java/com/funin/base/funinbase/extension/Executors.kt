package com.funin.base.funinbase.extension

import java.util.concurrent.Executors

private val IO_EXECUTOR = Executors.newSingleThreadExecutor()

/**
 * Utility method to run blocks on a dedicated background thread, used for io/database work.
 */
fun ioThread(block: () -> Unit) {
    IO_EXECUTOR.execute(block)
}

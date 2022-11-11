package com.example.bobburgers.util

/**
 * Constants values.
 *
 * @constructor Create empty Constants
 */
object Constants {
    const val homeScreen = "home_screen"
    const val TAG = "Logger"
    const val idDefault = 999
    const val PREFERENCES = ""

    /**
     * Get id from url if needed.
     *
     * @param url
     * @return
     */
    fun getIdFromUrl(url: String): Int {
        val index = url.lastIndexOf('/')
        return url.substring(index + 1).toInt()
    }
}

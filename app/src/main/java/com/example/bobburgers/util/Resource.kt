package com.example.bobburgers.util

/**
 * Resource used when sending request.
 *
 * @param T
 * @constructor Create empty Resource
 */
sealed class Resource<out T> {
    /**
     * Success block.
     *
     * @param T
     * @property data
     * @constructor Create empty Success
     */
    data class Success<T>(val data: T) : Resource<T>()

    /**
     * Loading block.
     *
     * @constructor Create empty Loading
     */
    object Loading : Resource<Nothing>()

    /**
     * Error block is error results.
     *
     * @property message
     * @constructor Create empty Error
     */
    data class Error(val message: String) : Resource<Nothing>()
}

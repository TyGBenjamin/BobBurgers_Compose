package com.example.bobburgers.model.remote

import com.example.bobburgers.model.entity.Bobcharacter

/**
 * [Network] response.
 *
 * @param T
 * @constructor Create empty Network response
 */
sealed class NetworkResponse<T> {
    /**
     * if response returns [Successful] response.
     *
     * @property characters
     * @constructor Create empty Successful response
     */
    data class SuccessfulResponse(
        val characters: List<Bobcharacter>
    ) : NetworkResponse<List<Bobcharacter>>()

    /**
     * Loading network response.
     *
     * @constructor Create empty Loading
     */
    object Loading : NetworkResponse<Unit>()

    /**
     * [Error] response.
     *
     * @property message
     * @constructor Create empty Error response
     */
    data class ErrorResponse(
        val message: String
    ) : NetworkResponse<String>()
}

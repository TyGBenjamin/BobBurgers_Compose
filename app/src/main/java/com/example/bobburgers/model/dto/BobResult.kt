package com.example.bobburgers.model.dto

import com.example.bobburgers.model.entity.Bobcharacter

/**
 * Bob result is regarding successful pull of items from Get Request.
 *
 * @constructor Create empty Bob result
 */
sealed class BobResult {
    /**
     * [Success] block.
     *
     * @property characters
     * @constructor Create empty Success
     */
    data class Success(
        val characters: List<Bobcharacter>
    ) : BobResult()

    /**
     * [Error] block.
     *
     * @property message
     * @constructor Create empty Error
     */
    data class Error(
        val message: String
    ) : BobResult()
}

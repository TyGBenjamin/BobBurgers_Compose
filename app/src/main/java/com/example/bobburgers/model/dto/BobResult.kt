package com.example.bobburgers.model.dto

import com.example.bobburgers.model.entity.Bobcharacter

sealed class BobResult{
    data class Success(
        val characters: List<Bobcharacter>
    ) : BobResult()
    data class Error(
        val message: String
    ): BobResult()
}

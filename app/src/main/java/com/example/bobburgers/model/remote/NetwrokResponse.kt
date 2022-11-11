package com.example.bobburgers.model.remote

import com.example.bobburgers.model.entity.Bobcharacter


sealed class NetworkResponse<T> {

    data class SuccessfulResponse(
        val characters: List<Bobcharacter>
    ) : NetworkResponse<List<Bobcharacter>>()

    object Loading : NetworkResponse<Unit>()

    data class ErrorResponse(
        val message: String
    ) : NetworkResponse<String>()
}



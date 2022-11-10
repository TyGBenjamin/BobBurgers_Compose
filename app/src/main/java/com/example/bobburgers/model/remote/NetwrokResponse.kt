package com.example.bobburgers.model.remote


sealed class NetworkResponse<T> {

    data class SuccessfulCategory(
        val characters: List<com.example.bobburgers.model.entity.Bobcharacter>
    ) : NetworkResponse<List<com.example.bobburgers.model.entity.Bobcharacter>>()

    object Loading : NetworkResponse<Unit>()

    data class Error(
        val message: String
    ) : NetworkResponse<String>()
}


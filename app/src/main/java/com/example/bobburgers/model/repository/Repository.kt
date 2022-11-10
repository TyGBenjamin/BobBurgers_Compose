package com.example.bobburgers.model.repository

import com.example.bobburgers.model.dto.CharacterDTO
import com.example.bobburgers.model.dto.CharacterResponse
import com.example.bobburgers.model.remote.ApiService
import com.example.bobburgers.util.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface Repository {
    suspend fun getCharacters() : Any
    suspend fun getCharacterById(id:Int) : Resource<CharacterDTO>
}

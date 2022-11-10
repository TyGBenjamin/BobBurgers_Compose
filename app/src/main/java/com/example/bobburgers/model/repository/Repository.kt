package com.example.bobburgers.model.repository

import com.example.bobburgers.model.dto.CharacterDTO
import com.example.bobburgers.model.dto.CharacterResponse
import retrofit2.Call

interface Repository {
    suspend fun getCharacters() : Call<CharacterResponse>
    suspend fun getCharacterById(id:Int) : Call<CharacterDTO>
}

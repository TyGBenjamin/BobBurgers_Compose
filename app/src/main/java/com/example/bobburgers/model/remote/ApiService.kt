package com.example.bobburgers.model.remote

import com.example.bobburgers.model.dto.CharacterDTO
import com.example.bobburgers.model.dto.CharacterResponse
import com.example.bobburgers.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET(Constants.CHAR_LIST)
    suspend fun getCharacters(): Response<CharacterResponse>

    @GET(Constants.CHAR_DETAIL)
    suspend fun getCharacterById(@Path("id") id: Int): Response<CharacterDTO>
}

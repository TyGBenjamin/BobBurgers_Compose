package com.example.bobburgers.model.remote

import com.example.bobburgers.model.dto.CharacterResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Bob service.
 *
 * @constructor Create empty Bob service
 */
interface BobService {
    @GET(CHARACTER_ENDPOINT)
    fun getAllCharacters(@Query("limit") amount: Int = 30): Call<CharacterResponse>

    companion object {
        private const val CHARACTER_ENDPOINT = "characters"
    }
}

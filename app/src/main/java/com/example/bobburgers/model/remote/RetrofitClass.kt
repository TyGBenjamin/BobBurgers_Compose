package com.example.bobburgers.model.remote

import kotlinx.serialization.ExperimentalSerializationApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**
 * [Retrofit] class for building retrofit [JSON] converter.
 *
 * @constructor Create empty Retrofit class
 */
@OptIn(ExperimentalSerializationApi::class)
object RetrofitClass {
    private const val BASE_URL = "https://bobsburgers-api.herokuapp.com/"

//    private val mediaType = "application/json".toMediaType()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    /**
     * Get api service.
     *
     * @return
     */
    fun getApiService(): BobService = retrofit.create()
}

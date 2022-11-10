package com.example.bobburgers.model.remote

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


@OptIn(ExperimentalSerializationApi::class)
object RetrofitClass {
    private const val CHAR_LIST =  "characters/"
    private const val BASE_URL = "https://bobsburgers-api.herokuapp.com/characters/"

    private val mediaType = "application/gson".toMediaType()

    private val json = Json {
        ignoreUnknownKeys = true
    }


    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getApiService(): BobService = retrofit.create()

}


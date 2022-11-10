package com.example.bobburgers.model.remote

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create


@OptIn(ExperimentalSerializationApi::class)
object RetrofitClass {
    private const val CHAR_LIST =  "characters/"
    private const val BASE_URL = "https://bobsburgers-api.herokuapp.com/$CHAR_LIST"

    private val mediaType = "application/json".toMediaType()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(Json.asConverterFactory(mediaType))
        .build()

    fun getApiService(): ApiService = retrofit.create()

}


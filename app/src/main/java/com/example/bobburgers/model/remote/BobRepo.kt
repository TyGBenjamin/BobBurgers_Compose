package com.example.bobburgers.model.remote

import com.example.bobburgers.model.dto.BobResult
import com.example.bobburgers.model.dto.CharacterDTO
import com.example.bobburgers.model.mapper.character.CharacterMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class BobRepo (
    private val service: BobService,
    val mapper: CharacterMapper
    ){
    suspend fun getCharacters(limit:Int = 30) = withContext(Dispatchers.IO){
        val charResponse: Response<List<CharacterDTO>> = service.getCharacters(limit).execute()

        if (charResponse.isSuccessful){
            val list = charResponse.body() ?: emptyList()
            val result = list.map {
                mapper(it)
            }
            BobResult.Success(
                result
            )
        } else {
            BobResult.Error(charResponse.message())
        }

    }
}

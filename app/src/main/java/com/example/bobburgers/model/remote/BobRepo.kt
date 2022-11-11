package com.example.bobburgers.model.remote

import com.example.bobburgers.model.dto.CharacterResponse
import com.example.bobburgers.model.entity.Bobcharacter
import com.example.bobburgers.model.mapper.character.CharacterMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

/**
 * Bob repo for getting list and mapping to data class.
 *
 * @property service
 * @property characterMapper
 * @constructor Create empty Bob repo
 */
class BobRepo(
    private val service: BobService,
    private val characterMapper: CharacterMapper
) {
    /**
     * Get characters from API Service.
     *
     * @return
     */
    suspend fun getCharacters(): NetworkResponse<*> = withContext(Dispatchers.IO) {
        val charResponse: Response<CharacterResponse> = service.getAllCharacters(NUM_VAL).execute()
        if (charResponse.isSuccessful) {
            val charList = charResponse.body() ?: CharacterResponse()
            print(charList)
            val characterList: List<Bobcharacter> = charList.map {
                characterMapper(it)
            }
            return@withContext NetworkResponse.SuccessfulResponse(characterList)
        } else {
            return@withContext NetworkResponse.ErrorResponse(charResponse.message())
        }
    }

    companion object {
        // want to grab all characters some from API, and randomly choose 30 in viewmodel
        // per project, this number should be 30
        const val NUM_VAL = 30
    }
}

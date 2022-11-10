package com.example.bobburgers.model.local

import com.example.bobburgers.model.dto.CharacterDTO
import com.example.bobburgers.model.dto.CharacterResponse
import com.example.bobburgers.model.remote.ApiService
import com.example.bobburgers.model.repository.Repository
import com.example.bobburgers.util.Resource
import java.util.IllegalFormatException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepositoryImpl (private var apiInstance: ApiService) : Repository {
    override suspend fun getCharacters() : Any =
        withContext(Dispatchers.IO) {
            return@withContext try {
                val res = apiInstance.getCharacters()
                if (res.isSuccessful && res.body() != null) {

                    val body = res.body()
                    val charList = body!!.characters
                    val list = charList.map { char ->
                        com.example.bobburgers.model.entity.Character(
                            id = char.id,
                            firstEpisode = char.firstEpisode,
                            gender = char.gender,
                            name = char.name,
                            image = char.image,
                            occupation = char.occupation
                        )
                    }
                    Resource.Success(list) as List<com.example.bobburgers.model.entity.Character>
                } else {
                    Resource.Error(res.message())
                }

            } catch (e: IllegalAccessError) {
                Resource.Error(e.message.toString())
            }
        }

    override suspend fun getCharacterById(id: Int): Resource<CharacterDTO> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                val res = apiInstance.getCharacterById(id)
                if (res.isSuccessful && res.body() != null) {
                    Resource.Success(res.body()!!)
                } else {
                    Resource.Error("Someting Wrong")
                }
            } catch (e: IllegalFormatException) {
                Resource.Error(e.message.toString())
            }
        }
}

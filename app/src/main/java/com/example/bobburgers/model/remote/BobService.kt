package com.example.bobburgers.model.remote


import com.example.bobburgers.model.dto.CharacterDTO
import com.example.bobburgers.model.dto.CharacterResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
/**
 * Service to hit the Bob's Burgers Api.
 */
//interface BobService {
//    companion object {
//        const val BASE_URL = "https://bobsburgers-api.herokuapp.com/"
//        private const val CHARACTER_ENDPOINT = "characters"
//        private const val SORT_QUERY = "sortBy"
//        private const val ORDER_QUERY = "OrderBy"
//        private const val LIMIT_QUERY = "limit"
//        private const val SKIP_QUERY = "skip"
//    }
//    /**
//     * Gets a list of [BobCharacterDTO] objects from the api.
//     *
//     */
//    @GET(CHARACTER_ENDPOINT)
//    fun getCharacters(
//        @Query(LIMIT_QUERY) charLim: Int = 30,
//        @Query(SORT_QUERY) sort: String = "name",
//        @Query(ORDER_QUERY) order: String = "asc",
//        @Query(SKIP_QUERY) skip: Int = 0
//    ): Call<ArrayList<CharacterDTO>>}

interface BobService {
    @GET(CHARACTER_ENDPOINT)
    fun getAllCharacters(@Query("limit") amount: Int = 30): Call<CharacterResponse>

    companion object {
        private const val CHARACTER_ENDPOINT = "characters"
    }
}


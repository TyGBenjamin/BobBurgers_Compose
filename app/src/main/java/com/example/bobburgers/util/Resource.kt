package com.example.bobburgers.util

sealed class Resource<out T> {
    data class Success<T>(val data: T) : Resource<T>()
    object Loading : Resource<Nothing>()
    data class Error(val message: String) : Resource<Nothing>()

 fun Resource<@UnsafeVariance T>.toCharacterList(): List<T> {
     return List<T>(size = 30, init = {it -> it as T})
 }
}

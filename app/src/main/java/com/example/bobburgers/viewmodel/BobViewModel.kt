package com.example.bobburgers.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.bobburgers.model.dto.BobResult
import com.example.bobburgers.model.remote.BobRepo
import com.example.bobburgers.view.homescreen.HomeScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BobViewModel(
    private val repo: BobRepo
) : ViewModel() {
    private val TAG = "MealViewModel"

    private val _homeState: MutableStateFlow<HomeScreenState> =
        MutableStateFlow(HomeScreenState())
    val homeState: StateFlow<HomeScreenState> get() = _homeState


    fun getCharacters(limit:Int = 30) = viewModelScope.launch {
        _homeState.update { it.copy(isLoading = true) }
        val characters: BobResult = repo.getCharacters(limit)
        when (characters) {
            is BobResult.Error -> {
                _homeState.update {
                    it.copy(
                        isLoading = false,
                        error = characters.message
                    )
                }
            }
            is BobResult.Success -> {
                _homeState.update { it.copy(isLoading = false, characters = it.characters) }

            }
            else -> {
                Log.e(TAG, "getCharacters: This is not working properly", )}
        }
    }
}


class VMlFactory(
    private val repo: BobRepo
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BobViewModel::class.java)) {
            return BobViewModel(repo) as T
        } else {
            throw IllegalArgumentException("not working")
        }
    }
}


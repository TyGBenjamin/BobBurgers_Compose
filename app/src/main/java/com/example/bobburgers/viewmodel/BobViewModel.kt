package com.example.bobburgers.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.bobburgers.model.dto.BobResult
import com.example.bobburgers.model.remote.BobRepo
import com.example.bobburgers.model.remote.BobRepo.Companion.NUM_VAL
import com.example.bobburgers.model.remote.NetworkResponse
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
        MutableStateFlow(HomeScreenState(characters = listOf()))
    val homeState: StateFlow<HomeScreenState> get() = _homeState


    fun getCharacters() {
        viewModelScope.launch {
            _homeState.update { state -> state.copy(isLoading = true) }
            val charResponse = repo.getCharacters()
            when (charResponse) {
                is NetworkResponse.SuccessfulResponse -> {
                    _homeState.update { state ->
                        state.copy(
                            isLoading = false,
                            characters = charResponse.characters
                                .asSequence()
                                .take(NUM_VAL)
                                .toList()

                        )
                    }
                }
                is NetworkResponse.ErrorResponse -> {
                    _homeState.update { state ->
                        state.copy(isLoading = false, error = charResponse.message)
                    }
                }
                else -> Log.e(TAG, "Network response issue")
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
}


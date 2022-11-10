package com.example.bobburgers.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.bobburgers.model.converter.ResourceConverter
import com.example.bobburgers.model.entity.Character
import com.example.bobburgers.model.local.RepositoryImpl
import com.example.bobburgers.util.Resource
import com.example.bobburgers.view.homescreen.HomeScreenState
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BobViewModel(
    private val repo: RepositoryImpl,

    ) : ViewModel() {
    private val TAG = "MealViewModel"

    private val _homeState: MutableStateFlow<HomeScreenState> =
        MutableStateFlow(HomeScreenState())
    val homeState: StateFlow<HomeScreenState> get() = _homeState


    fun getCharacters() = viewModelScope.launch {
        _homeState.update { state -> state.copy(isLoading = true) }
        viewModelScope.launch {
            val charList = repo.getCharacters()
            _homeState.update { state ->
                state.copy(
                    isLoading = false,
                    characters = charList as List<Character>
                )
            }
        }
    }
}

class VMlFactory(
    private val repo: RepositoryImpl
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BobViewModel::class.java)) {
            return BobViewModel(repo) as T
        } else {
            throw IllegalArgumentException("not working")
        }
    }
}


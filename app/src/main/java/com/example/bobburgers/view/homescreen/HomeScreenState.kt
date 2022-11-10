package com.example.bobburgers.view.homescreen

import com.example.bobburgers.model.entity.Bobcharacter

//data class HomeScreenState(
//    val isLoading: Boolean = false,
//    val characters: Resource<List<com.example.bobburgers.model.entity.Character>?> = listOf<com.example.bobburgers.model.entity.Character>(),
//    val error: String = ""
//)

data class HomeScreenState(
    val isLoading: Boolean = false,
    val characters: List<Bobcharacter> = listOf(),
    val error: String = ""
)




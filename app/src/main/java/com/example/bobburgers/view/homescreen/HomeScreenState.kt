package com.example.bobburgers.view.homescreen

import com.example.bobburgers.model.entity.Bobcharacter

/**
 * Home screen state.
 *
 * @property isLoading
 * @property characters
 * @property error
 * @constructor Create empty Home screen state
 */
data class HomeScreenState(
    val isLoading: Boolean = false,
    val characters: List<Bobcharacter>,
    val error: String = ""
)

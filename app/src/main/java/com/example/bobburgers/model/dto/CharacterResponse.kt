package com.example.bobburgers.model.dto

@kotlinx.serialization.Serializable
data class CharacterResponse(
    val characters:Array<List<CharacterDTO>>
)

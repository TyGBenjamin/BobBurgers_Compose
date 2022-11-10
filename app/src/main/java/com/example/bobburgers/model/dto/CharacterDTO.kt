package com.example.bobburgers.model.dto

@kotlinx.serialization.Serializable
data class CharacterDTO(
    val firstEpisode: String,
    val gender: String,
    val hairColor: String,
    val id: Int,
    val image: String,
    val name: String,
    val occupation: String,
    val relatives: List<RelativeDTO>,
    val url: String,
    val voicedBy: String,
    val wikiUrl: String
)

package com.example.bobburgers.model.dto

import com.example.bobburgers.model.entity.Relative
import kotlinx.serialization.Contextual

@kotlinx.serialization.Serializable
data class CharacterDTO(
    val firstEpisode: String,
    val gender: String,
    val hairColor: String,
    val id: Int,
    val image: String,
    val name: String,
    val occupation: String,
    val relatives: List<String>,
    val url: String,
    val voicedBy: String,
    val wikiUrl: String
)

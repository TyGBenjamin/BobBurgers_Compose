package com.example.bobburgers.model.dto

import com.example.bobburgers.util.Constants
import kotlinx.serialization.Serializable

@Serializable
data class CharacterDTO(
    val age: String? = "",
    val firstEpisode: String? = "",
    val gender: String? = "",
    val hairColor: String? = "",
    val id: Int? = Constants.idDefault,
    val image: String? = "",
    val name: String? = "",
    val occupation: String? = "",
    val relatives: List<RelativeDTO>? = listOf(),
    val url: String? = "",
    val voicedBy: String? = "",
    val wikiUrl: String? = ""
)

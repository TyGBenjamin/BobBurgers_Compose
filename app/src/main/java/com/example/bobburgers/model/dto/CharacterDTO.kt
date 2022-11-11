package com.example.bobburgers.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class CharacterDTO(
    val age: String? = "",
    val firstEpisode: String?= "",
    val gender: String?= "",
    val hairColor: String?= "",
    val id: Int?=999,
    val image: String?= "",
    val name: String?= "",
    val occupation: String?= "",
    val relatives: List<RelativeDTO>? = listOf(),
    val url: String?= "",
    val voicedBy: String?= "",
    val wikiUrl: String?= ""
)


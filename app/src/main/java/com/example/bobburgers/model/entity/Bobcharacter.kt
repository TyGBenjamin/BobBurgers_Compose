package com.example.bobburgers.model.entity

import com.example.bobburgers.model.dto.RelativeDTO

data class Bobcharacter(
    val age: String,
    val firstEpisode: String,
    val gender: String,
    val hairColor: String,
    val id: Int,
    val image: String,
    val name: String,
    val occupation: String,
    val relatives: List<Relative>,
    val url: String,
    val voicedBy: String,
    val wikiUrl: String

)


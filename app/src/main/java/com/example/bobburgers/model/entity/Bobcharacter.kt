package com.example.bobburgers.model.entity

/**
 * Bobcharacter data class.
 *
 * @property age
 * @property firstEpisode
 * @property gender
 * @property hairColor
 * @property id
 * @property image
 * @property name
 * @property occupation
 * @property relatives
 * @property url
 * @property voicedBy
 * @property wikiUrl
 * @constructor Create empty Bobcharacter
 */
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

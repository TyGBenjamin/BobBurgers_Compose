package com.example.bobburgers.model.mapper.character

import com.example.bobburgers.model.entity.Bobcharacter
import com.example.bobburgers.model.dto.CharacterDTO
import com.example.bobburgers.model.mapper.Mapper
import com.example.bobburgers.model.mapper.RelativeMapper

/**
 * Card mapper to convert [CardDTO] to [Card] entity.
 *
 * @constructor Create empty Student mapper.
 */

class CharacterMapper(private val relativeMapper: RelativeMapper):
    Mapper<CharacterDTO, Bobcharacter> {
    override fun invoke(dto: CharacterDTO): Bobcharacter {
        return with(dto) {
            Bobcharacter(
                age = age ?: "",
                firstEpisode = firstEpisode ?: "",
                gender = gender ?: "",
                hairColor = hairColor ?: "",
                id = id ?: 999,
                image = image ?: "",
                name = name ?: "",
                occupation = occupation ?: "",
                relatives =  relatives?.map { relativeMapper(it) } ?: emptyList(),
                url = url ?: "",
                voicedBy = voicedBy ?: "",
                wikiUrl = wikiUrl ?: ""
            )
        }
    }
}


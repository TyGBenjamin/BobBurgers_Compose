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

class CharacterMapper : Mapper<CharacterDTO, Bobcharacter> {
    private val relativeMapper by lazy {RelativeMapper()}

    override fun invoke(dto: CharacterDTO): Bobcharacter =
        with(dto) {
            val relativeList = relatives.map { it.toRelative(relativeMapper) }
            Bobcharacter(
                image,
                name,
                occupation,
                id,
                url,
                wikiUrl,
                hairColor,
                relativeList,
                voicedBy,
                gender,
                firstEpisode
            )
        }
}

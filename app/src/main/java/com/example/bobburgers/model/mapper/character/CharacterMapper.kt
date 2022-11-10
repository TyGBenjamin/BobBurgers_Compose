package com.example.bobburgers.model.mapper.character

import com.example.bobburgers.model.dto.CharacterDTO
import com.example.bobburgers.model.entity.Character
import com.example.bobburgers.model.mapper.Mapper

/**
 * Card mapper to convert [CardDTO] to [Card] entity.
 *
 * @constructor Create empty Student mapper.
 */

class CharacterMapper : Mapper<CharacterDTO, com.example.bobburgers.model.entity.Character> {

    override fun invoke(dto: CharacterDTO): com.example.bobburgers.model.entity.Character =
        with(dto) {
            com.example.bobburgers.model.entity.Character(
                id,
                firstEpisode,
                gender,
                image,
                name,
                occupation
            )
        }
}

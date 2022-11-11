package com.example.bobburgers.model.mapper

import com.example.bobburgers.model.dto.RelativeDTO
import com.example.bobburgers.model.entity.Relative

/**
 * Relative mapper for mapping DTO to data class objects.
 *
 * @constructor Create empty Relative mapper
 */
class RelativeMapper : Mapper<RelativeDTO, Relative> {
    override fun invoke(dto: RelativeDTO): Relative {
        return with(dto) {
            Relative(
                name = name ?: "",
                relationship = relationship ?: ""
            )
        }
    }
}

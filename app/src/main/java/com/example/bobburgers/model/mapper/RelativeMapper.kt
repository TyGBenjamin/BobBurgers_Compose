package com.example.bobburgers.model.mapper

import com.example.bobburgers.model.dto.RelativeDTO
import com.example.bobburgers.model.entity.Relative


class RelativeMapper: Mapper<RelativeDTO, Relative> {
    override fun invoke(dto: RelativeDTO): Relative {
        return with(dto) {
            Relative(
                name = name ?: "",
                relationship = relationship ?: "",
            )
        }
    }
}

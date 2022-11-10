package com.example.bobburgers.model.mapper

import com.example.bobburgers.model.dto.RelativeDTO
import com.example.bobburgers.model.entity.Relative

class RelativeMapper: Mapper<RelativeDTO,Relative>{
    override fun invoke(dto: RelativeDTO): Relative  = with(dto) {
        Relative(
        dto.relationship,
        dto.name,
        dto.url,
        dto.wikiUrl
        )
    }

}

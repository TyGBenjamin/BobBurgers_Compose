package com.example.bobburgers.model.dto

import com.example.bobburgers.model.entity.Relative
import com.example.bobburgers.model.mapper.RelativeMapper

@kotlinx.serialization.Serializable
data class RelativeDTO(
    val name: String? = "",
    val relationship: String = "",
    val url: String? = "",
    val wikiUrl: String = ""
) {
    fun toRelative(mapper: RelativeMapper): Relative {
        return mapper(this)
    }
}

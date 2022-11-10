package com.example.bobburgers.model.converter

import com.example.bobburgers.model.entity.Bobcharacter
import com.example.bobburgers.util.Resource

class ResourceConverter(resource: Resource<List<Bobcharacter>?>) {

    /**
     * Invokes the mapping of the [Resource] to [T].
     *
     * @param resource4 representation of json from server
     * @return representation of dto properties that are needed for local usage.
     */
    fun invoke(resource: com.example.bobburgers.util.Resource<List<Bobcharacter>?>): List<*>? {
        return this as List<*>?
    }
}

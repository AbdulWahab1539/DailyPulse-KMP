package com.abdul.dev.dailypulse.sources.domain

import com.abdul.dev.dailypulse.sources.data.SourceRaw
import com.abdul.dev.dailypulse.sources.data.SourcesRepository

class SourcesUseCase(
    private val repository: SourcesRepository
) {

    suspend fun getSources(): List<Source> {
        val sourcesRaw = repository.getSources()
        return mapSources(sourcesRaw)
    }

    private fun mapSources(
        articlesRaw: List<SourceRaw>
    ): List<Source> =
        articlesRaw.map {
            Source(
                id = it.id,
                name = it.name,
                description = it.description,
                details = "${it.language} - ${it.country}"
            )
        }
}
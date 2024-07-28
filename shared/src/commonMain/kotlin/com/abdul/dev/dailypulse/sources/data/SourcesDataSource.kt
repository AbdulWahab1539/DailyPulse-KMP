package com.abdul.dev.dailypulse.sources.data

import abdul.dev.dailypulse.db.DailyPulseDatabase

class SourcesDataSource(
    private val database: DailyPulseDatabase
) {
    fun getAllSources(): List<SourceRaw> =
        database.dailyPulseDatabaseQueries.selectAllSource(
            ::mapToSourcesRaw
        ).executeAsList()

    fun insertSources(sources: List<SourceRaw>) {
        database.dailyPulseDatabaseQueries.transaction {
            sources.forEach { sourceRaw ->
                insertSource(sourceRaw)
            }
        }
    }

    private fun insertSource(sourceRaw: SourceRaw) {
        database.dailyPulseDatabaseQueries.insertSource(
            sourceRaw.id,
            sourceRaw.name,
            sourceRaw.description,
            sourceRaw.country,
            sourceRaw.language,
        )
    }

    private fun mapToSourcesRaw(
        id: String,
        name: String,
        description: String,
        language: String,
        country: String
    ): SourceRaw = SourceRaw(
        country = country,
        id = id,
        name = name,
        language = language,
        description = description
    )
}
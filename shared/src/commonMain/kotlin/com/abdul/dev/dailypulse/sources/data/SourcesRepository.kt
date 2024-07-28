package com.abdul.dev.dailypulse.sources.data

class SourcesRepository(
    private val dataSource: SourcesDataSource,
    private val service: SourcesService
) {
    suspend fun getSources(): List<SourceRaw> {
        val cachedSources = dataSource.getAllSources()
        if (cachedSources.isEmpty()) {
            return fetchSources()
        }
        return cachedSources
    }

    private suspend fun fetchSources(): List<SourceRaw> {
        val fetchedSources = service.fetchSources()
        dataSource.insertSources(fetchedSources)
        return fetchedSources
    }
}
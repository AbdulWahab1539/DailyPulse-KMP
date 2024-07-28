package com.abdul.dev.dailypulse.sources.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class SourcesService(
    private val httpClient: HttpClient
) {
    private val apiKey = "98ecd39ef8184bf3a2dafc454db39b99"

    suspend fun fetchSources(): List<SourceRaw> {
        val response: SourcesResponse =
            httpClient.get(
                "https://newsapi.org/v2/top-headlines/sources?apiKey=$apiKey"
            ).body()
        return response.sources
    }
}
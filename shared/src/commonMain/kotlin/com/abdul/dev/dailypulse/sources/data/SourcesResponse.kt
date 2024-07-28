package com.abdul.dev.dailypulse.sources.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SourcesResponse(
    @SerialName("sources")
    val sources: List<SourceRaw>,
    @SerialName("status")
    val status: String
)
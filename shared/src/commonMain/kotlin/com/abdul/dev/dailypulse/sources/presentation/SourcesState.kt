package com.abdul.dev.dailypulse.sources.presentation

import com.abdul.dev.dailypulse.sources.domain.Source

data class SourcesState(
    val sources: List<Source> = listOf(),
    val loading: Boolean = false,
    val error: String? = null,
)

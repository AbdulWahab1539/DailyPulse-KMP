package com.abdul.dev.dailypulse.sources.presentation

import com.abdul.dev.dailypulse.BaseViewModel
import com.abdul.dev.dailypulse.sources.domain.SourcesUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class SourcesViewModel(
    private val useCase: SourcesUseCase
) : BaseViewModel() {

    private val _sourcesState: MutableStateFlow<SourcesState> =
        MutableStateFlow(SourcesState(loading = true))
    val sourcesState: StateFlow<SourcesState> get() = _sourcesState


    init {
        getSources()
    }

    fun getSources() {
        scope.launch {
            _sourcesState.update {
                SourcesState(
                    loading = true,
                    sources = it.sources
                )
            }

            val fetched = useCase.getSources()
            delay(1.seconds)
            _sourcesState.update {
                SourcesState(sources = fetched)
            }
        }
    }
}
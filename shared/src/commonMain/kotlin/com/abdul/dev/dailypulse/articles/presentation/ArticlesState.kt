package com.abdul.dev.dailypulse.articles.presentation

import com.abdul.dev.dailypulse.articles.application.Article

data class ArticlesState(
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null,
)
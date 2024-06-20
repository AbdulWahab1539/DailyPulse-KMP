package com.abdul.dev.dailypulse.articles.data

import com.abdul.dev.dailypulse.articles.data.ArticleRaw
import com.abdul.dev.dailypulse.articles.data.ArticlesDataSource
import com.abdul.dev.dailypulse.articles.data.ArticlesService

class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val service: ArticlesService
) {
    suspend fun getArticles(
        isForceRefresh: Boolean
    ): List<ArticleRaw> {
        if (isForceRefresh) {
            dataSource.clearArticles()
            return fetchArticles()
        }
        val cachedArticles = dataSource.getAllArticles()
        if (cachedArticles.isEmpty()) {
            return fetchArticles()
        }
        return cachedArticles
    }

    private suspend fun fetchArticles(): List<ArticleRaw> {
        val fetchedArticles = service.fetchArticles()
        dataSource.insertArticles(fetchedArticles)
        return fetchedArticles
    }
}
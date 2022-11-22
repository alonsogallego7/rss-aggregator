package com.alonsogallego.rss_aggregator.app.domain

class SaveSourceRssUseCase(private val sourceRssRepository: SourceRssRepository) {

    suspend fun execute(name: String, url: String) {
        sourceRssRepository.create(name, url)
    }

    data class SourceRss(
        val name: String,
        val url: String
    )
}
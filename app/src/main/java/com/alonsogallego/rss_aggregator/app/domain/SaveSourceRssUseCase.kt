package com.alonsogallego.rss_aggregator.app.domain

class SaveSourceRssUseCase(private val sourceRssRepository: SourceRssRepository) {
    suspend fun execute(webName: String, url: String) {
        sourceRssRepository.create(webName, url)
    }
}
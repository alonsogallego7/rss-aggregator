package com.alonsogallego.rss_aggregator.domain

class DeleteSourceRssUseCase(private val sourceRssRepository: SourceRssRepository) {
    suspend fun invoke(webName: String) {
         sourceRssRepository.delete(webName)
    }
}
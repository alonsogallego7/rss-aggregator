package com.alonsogallego.rss_aggregator.domain

class GetSourceRssUseCase(private val sourceRssRepository: SourceRssRepository) {
    suspend fun invoke(): List<SourceRssModel> {
        return sourceRssRepository.getAll()
    }
}
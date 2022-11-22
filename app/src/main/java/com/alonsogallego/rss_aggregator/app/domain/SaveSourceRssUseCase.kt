package com.alonsogallego.rss_aggregator.app.domain

class SaveSourceRssUseCase {

    suspend fun execute(): SourceRss {

    }

    data class SourceRss (
        val name: String,
        val url: String
    )
}
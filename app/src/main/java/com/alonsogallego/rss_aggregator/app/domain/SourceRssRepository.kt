package com.alonsogallego.rss_aggregator.app.domain

interface SourceRssRepository {
    suspend fun create(name: String, url: String)
}
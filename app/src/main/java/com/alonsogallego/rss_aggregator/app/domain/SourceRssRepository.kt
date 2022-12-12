package com.alonsogallego.rss_aggregator.app.domain

interface SourceRssRepository {
    suspend fun create(webName: String, url: String)
}
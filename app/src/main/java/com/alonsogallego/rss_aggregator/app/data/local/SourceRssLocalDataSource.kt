package com.alonsogallego.rss_aggregator.app.data.local

interface SourceRssLocalDataSource {
    suspend fun create(webName: String, url: String)
}
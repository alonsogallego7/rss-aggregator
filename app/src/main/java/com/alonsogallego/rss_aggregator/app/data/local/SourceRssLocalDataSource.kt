package com.alonsogallego.rss_aggregator.app.data.local

interface SourceRssLocalDataSource {
    fun create(webName: String, url: String)
}
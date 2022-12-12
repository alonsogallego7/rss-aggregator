package com.alonsogallego.rss_aggregator.data.local

interface SourceRssLocalDataSource {
    fun create(webName: String, url: String)
}
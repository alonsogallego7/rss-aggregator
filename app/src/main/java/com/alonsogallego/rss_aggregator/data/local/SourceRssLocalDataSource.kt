package com.alonsogallego.rss_aggregator.data.local

import com.alonsogallego.rss_aggregator.domain.SourceRssModel

interface SourceRssLocalDataSource {
    fun create(webName: String, url: String)
    fun getAll(): List<SourceRssModel>
}
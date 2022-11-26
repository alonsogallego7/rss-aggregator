package com.alonsogallego.rss_aggregator.app.data.local.db

import com.alonsogallego.rss_aggregator.app.data.local.SourceRssLocalDataSource

class SourceRssDbLocalDataSource(private val dao: SourceRssDao): SourceRssLocalDataSource {
    override fun create(webName: String, url: String) {

    }
}
package com.alonsogallego.rss_aggregator.app.data

import com.alonsogallego.rss_aggregator.app.data.local.SourceRssLocalDataSource

class SourceRssDataRepository(private val localSource: SourceRssLocalDataSource) {

    suspend fun create(webName: String, url: String) {

    }

}
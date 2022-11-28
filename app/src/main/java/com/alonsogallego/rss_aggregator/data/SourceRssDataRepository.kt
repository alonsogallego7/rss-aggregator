package com.alonsogallego.rss_aggregator.data

import com.alonsogallego.rss_aggregator.data.local.SourceRssLocalDataSource

class SourceRssDataRepository(private val localSource: SourceRssLocalDataSource) {

    suspend fun create(webName: String, url: String) {
        localSource.create(webName, url)
    }

}
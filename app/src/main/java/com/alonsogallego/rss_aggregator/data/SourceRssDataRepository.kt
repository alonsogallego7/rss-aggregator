package com.alonsogallego.rss_aggregator.data

import com.alonsogallego.rss_aggregator.app.domain.SourceRssRepository
import com.alonsogallego.rss_aggregator.data.local.SourceRssLocalDataSource

class SourceRssDataRepository(private val localSource: SourceRssLocalDataSource): SourceRssRepository {

    override suspend fun create(webName: String, url: String) {
        localSource.create(webName, url)
    }

}
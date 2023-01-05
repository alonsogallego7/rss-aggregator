package com.alonsogallego.rss_aggregator.data

import com.alonsogallego.rss_aggregator.data.local.SourceRssLocalDataSource
import com.alonsogallego.rss_aggregator.domain.SourceRssModel
import com.alonsogallego.rss_aggregator.domain.SourceRssRepository

class SourceRssDataRepository(private val localSource: SourceRssLocalDataSource):
    SourceRssRepository {

    override suspend fun create(webName: String, url: String) {
        localSource.create(webName, url)
    }

    override suspend fun getAll(): List<SourceRssModel> {
        TODO("Not yet implemented")
    }

}
package com.alonsogallego.rss_aggregator.data.local.db

import com.alonsogallego.app.domain.ErrorApp
import com.alonsogallego.app.functional.Either
import com.alonsogallego.rss_aggregator.data.local.SourceRssLocalDataSource
import com.alonsogallego.rss_aggregator.domain.SourceRssModel

class SourceRssDbLocalDataSource(private val dao: SourceRssDao): SourceRssLocalDataSource {
    override fun create(webName: String, url: String) {
        val sourceRss = SourceRssEntity(
            0,
            webName,
            url
        )
        dao.create(sourceRss)
    }

    override fun getAll(): List<SourceRssModel> {
        val sourceRss = mutableListOf<SourceRssModel>()
        dao.getAll().map {
            sourceRss.add(it.toDomain())
        }
        return sourceRss
    }

    override fun delete(webName: String): Either<ErrorApp, Boolean> {

    }
}
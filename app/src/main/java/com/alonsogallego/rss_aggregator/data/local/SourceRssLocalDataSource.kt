package com.alonsogallego.rss_aggregator.data.local

import com.alonsogallego.app.domain.ErrorApp
import com.alonsogallego.app.functional.Either
import com.alonsogallego.rss_aggregator.domain.SourceRssModel

interface SourceRssLocalDataSource {
    fun create(webName: String, url: String)
    fun getAll(): List<SourceRssModel>
    fun delete(webName: String): Either<ErrorApp, Boolean>
}
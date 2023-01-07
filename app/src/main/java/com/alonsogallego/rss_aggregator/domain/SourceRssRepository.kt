package com.alonsogallego.rss_aggregator.domain

import com.alonsogallego.app.domain.ErrorApp
import com.alonsogallego.app.functional.Either

interface SourceRssRepository {
    suspend fun create(webName: String, url: String)
    suspend fun getAll(): List<SourceRssModel>
    suspend fun delete(webName: String): Either<ErrorApp, Boolean>
}
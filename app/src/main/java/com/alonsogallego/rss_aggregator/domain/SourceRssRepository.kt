package com.alonsogallego.rss_aggregator.domain

interface SourceRssRepository {
    suspend fun create(webName: String, url: String)
    suspend fun getAll(): List<SourceRssModel>
}
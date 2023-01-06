package com.alonsogallego.rss_aggregator.data.local.db

import com.alonsogallego.rss_aggregator.domain.SourceRssModel

fun SourceRssEntity.toDomain() = SourceRssModel(
    this.webName,
    this.url
)
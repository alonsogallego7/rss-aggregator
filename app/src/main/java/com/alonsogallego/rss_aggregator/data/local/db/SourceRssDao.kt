package com.alonsogallego.rss_aggregator.data.local.db

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface SourceRssDao {
    @Insert
    fun create(sourceRss: SourceRssEntity)
}
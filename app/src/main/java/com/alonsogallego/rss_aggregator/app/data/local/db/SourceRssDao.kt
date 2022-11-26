package com.alonsogallego.rss_aggregator.app.data.local.db

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface SourceRssDao {
    @Insert
    fun create(webName: String, url: String)
}
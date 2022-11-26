package com.alonsogallego.rss_aggregator.app.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import com.alonsogallego.rss_aggregator.app.domain.SourceRssModel

@Dao
interface SourceRssDao {
    @Insert
    fun create(rss: SourceRssModel)
}
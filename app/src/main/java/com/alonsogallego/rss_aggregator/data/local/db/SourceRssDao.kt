package com.alonsogallego.rss_aggregator.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SourceRssDao {
    @Insert
    fun create(sourceRss: SourceRssEntity)

    @Query("SELECT * FROM $TABLE_NAME_RSS")
    fun getAll(): List<SourceRssEntity>

    @Delete()
    fun delete(webName: String)
}
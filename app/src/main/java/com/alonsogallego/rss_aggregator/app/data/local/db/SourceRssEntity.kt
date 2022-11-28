package com.alonsogallego.rss_aggregator.app.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val TABLE_NAME_RSS = "source_rss"

@Entity(tableName = TABLE_NAME_RSS)
data class SourceRssEntity (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name="web_name") val webName: String,
    @ColumnInfo val url: String
)

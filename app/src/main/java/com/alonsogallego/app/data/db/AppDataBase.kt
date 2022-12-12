package com.alonsogallego.app.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alonsogallego.rss_aggregator.data.local.db.SourceRssDao
import com.alonsogallego.rss_aggregator.data.local.db.SourceRssEntity

@Database(entities = [SourceRssEntity::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun sourceRssDao(): SourceRssDao
}
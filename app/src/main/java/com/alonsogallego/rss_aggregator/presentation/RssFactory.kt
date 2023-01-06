package com.alonsogallego.rss_aggregator.presentation

import android.content.Context
import androidx.room.Room
import com.alonsogallego.app.data.db.AppDataBase
import com.alonsogallego.rss_aggregator.data.SourceRssDataRepository
import com.alonsogallego.rss_aggregator.data.local.db.SourceRssDbLocalDataSource
import com.alonsogallego.rss_aggregator.domain.GetSourceRssUseCase
import com.alonsogallego.rss_aggregator.domain.SaveSourceRssUseCase
import com.alonsogallego.rss_aggregator.domain.SourceRssRepository

class RssFactory {
    fun getRssSourceListViewModel(context: Context) = RssSourceListViewModel(
        getGetSourceRssUseCase(context)
    )

    fun getRssManagementViewModel(context: Context) = RssManagementViewModel(
        getSourceRssUseCase(context)
    )

    private fun getGetSourceRssUseCase(context: Context): GetSourceRssUseCase {
        return GetSourceRssUseCase(
            getSourceRssRepository(context)
        )
    }

    private fun getSourceRssUseCase(context: Context): SaveSourceRssUseCase {
        return SaveSourceRssUseCase(
            getSourceRssRepository(context)
        )
    }

    private fun getSourceRssRepository(context: Context): SourceRssRepository {
        return SourceRssDataRepository(
            SourceRssDbLocalDataSource(
                DataBaseSingleton.getInstance(context).sourceRssDao()
            )
        )
    }

    object DataBaseSingleton {
        private var db: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            if (db == null) {
                db = Room.databaseBuilder(
                    context,
                    AppDataBase::class.java, "db-rss"
                ).build()
            }
            return db!!
        }
    }
}
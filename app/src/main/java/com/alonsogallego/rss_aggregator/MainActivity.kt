package com.alonsogallego.rss_aggregator

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.alonsogallego.app.data.db.AppDataBase
import com.alonsogallego.rss_aggregator.data.SourceRssDataRepository
import com.alonsogallego.rss_aggregator.data.local.db.SourceRssDbLocalDataSource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            SourceRssDataRepository(SourceRssDbLocalDataSource(DataBaseSingleton.getInstance(applicationContext).sourceRssDao())).create("Marca Segunda División", "https://e00-marca.uecdn.es/rss/futbol/segunda-division.xml" )
        }
    }

    object DataBaseSingleton {
        private var db: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            if (db == null) {
                db = Room.databaseBuilder(
                    context,
                    AppDataBase::class.java, "db-sourcerss"
                ).build()
            }
            return db!!
        }

    }
}
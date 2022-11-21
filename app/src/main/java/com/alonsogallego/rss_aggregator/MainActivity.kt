package com.alonsogallego.rss_aggregator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alonsogallego.rss_aggregator.app.data.remote.api.ApiClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val apiClient = ApiClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            val rss = apiClient.getRss("https://e00-marca.uecdn.es/rss/futbol/sevilla.xml")
            Log.d("@dev", "rss: $rss")
        }
    }
}
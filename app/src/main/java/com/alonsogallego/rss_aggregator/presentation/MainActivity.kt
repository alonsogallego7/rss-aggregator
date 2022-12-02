package com.alonsogallego.rss_aggregator.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alonsogallego.rss_aggregator.R
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NavigationBarView.OnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.rss_feed -> {
                    // Respond to navigation item 1 click
                    true
                }
                R.id.management -> {
                    // Respond to navigation item 2 click
                    true
                }
                R.id.profile -> {
                    // Respond to navigation item 2 click
                    true
                }
                else -> false
            }
        }
    }
}
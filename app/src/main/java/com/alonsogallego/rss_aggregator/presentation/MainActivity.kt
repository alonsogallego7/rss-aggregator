package com.alonsogallego.rss_aggregator.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.alonsogallego.rss_aggregator.NavGraphDirections
import com.alonsogallego.rss_aggregator.R
import com.alonsogallego.rss_aggregator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.rss_feed -> {
                    navigateToRssFeed()
                    true
                }
                R.id.rss_management -> {
                    navigateToRssManagement()
                    true
                }
                R.id.profile -> {
                    navigateToProfile()
                    true
                }
                else -> false
            }
        }
    }

    private fun navigateToRssFeed() {
        findNavController(R.id.fragment_container_view).navigate(
            NavGraphDirections.toRssfeed()
        )
    }

    private fun navigateToRssManagement() {
        findNavController(R.id.fragment_container_view).navigate(
            NavGraphDirections.toRssmanagement()
        )
    }

    private fun navigateToProfile() {
        findNavController(R.id.fragment_container_view).navigate(
            RssFeedFragmentDirections.toProfile()
        )
    }
}
package com.alonsogallego.rss_aggregator.presentation

import androidx.lifecycle.ViewModel
import com.alonsogallego.rss_aggregator.domain.GetSourceRssUseCase

class RssSourceViewModel(private val getSourceRss: GetSourceRssUseCase): ViewModel() {
    fun loadSourceRss() {

    }

    data class SourceRssUiState(

    )
}
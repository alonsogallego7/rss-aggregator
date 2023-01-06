package com.alonsogallego.rss_aggregator.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alonsogallego.rss_aggregator.domain.GetSourceRssUseCase
import com.alonsogallego.rss_aggregator.domain.SourceRssModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RssSourceListViewModel(private val getSourceRss: GetSourceRssUseCase) : ViewModel() {
    val sourceRssListPublisher: MutableLiveData<SourceRssUiState> by lazy {
        MutableLiveData<SourceRssUiState>()
    }

    fun loadSourceRss() {
        viewModelScope.launch(Dispatchers.IO) {
            val sourceRss = getSourceRss.invoke()
            sourceRssListPublisher.postValue(
                SourceRssUiState(
                    sourceRss = sourceRss
                )
            )
        }
    }

    data class SourceRssUiState(
        val sourceRss: List<SourceRssModel> = emptyList()
    )
}
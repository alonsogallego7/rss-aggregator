package com.alonsogallego.rss_aggregator.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alonsogallego.rss_aggregator.app.domain.SaveSourceRssUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RssManagementViewModel(private val saveSourceRss: SaveSourceRssUseCase): ViewModel() {

    val sourceRssPublisher: MutableLiveData<SourceRssUiState> by lazy {
        MutableLiveData<SourceRssUiState>()
    }

    fun saveSourceRss(webName: String, url: String) {
        viewModelScope.launch(Dispatchers.IO) {
            saveSourceRss.execute(webName, url)
            sourceRssPublisher.postValue(
                SourceRssUiState(
                    true,
                    webName,
                    url
                )
            )
        }
    }

    data class SourceRssUiState(
        val isSuccess: Boolean = false,
        val webName: String = "",
        val url: String = ""
    )
}
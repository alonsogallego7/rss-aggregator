package com.alonsogallego.rss_aggregator.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alonsogallego.rss_aggregator.databinding.ViewItemRssSourceBinding
import com.alonsogallego.rss_aggregator.domain.SourceRssModel

class RssSourceViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(sourceRss: SourceRssModel, itemClick: ((String) -> Unit)?) {
        val binding = ViewItemRssSourceBinding.bind(view)
        binding.webName.text = sourceRss.webName
        binding.url.text = sourceRss.url
        view.setOnClickListener {
            itemClick?.invoke(sourceRss.webName)
        }
    }
}
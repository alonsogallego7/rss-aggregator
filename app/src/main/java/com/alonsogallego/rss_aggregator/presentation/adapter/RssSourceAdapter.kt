package com.alonsogallego.rss_aggregator.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alonsogallego.rss_aggregator.R
import com.alonsogallego.rss_aggregator.domain.SourceRssModel

class RssSourceAdapter: RecyclerView.Adapter<RssSourceViewHolder>() {

    private val dataItems = mutableListOf<SourceRssModel>()
    private var itemClick: ((String) -> Unit)? = null

    fun setOnClickItem(itemClick: (String) -> Unit) {
        this.itemClick = itemClick
    }

    fun setDataItems(sourceRss: List<SourceRssModel>) {
        dataItems.clear()
        dataItems.addAll(sourceRss)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RssSourceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_item_rss_source, parent, false)
        return RssSourceViewHolder(view)
    }

    override fun onBindViewHolder(holder: RssSourceViewHolder, position: Int) {
        holder.bind(dataItems[position], itemClick)
    }

    override fun getItemCount(): Int = dataItems.size

}
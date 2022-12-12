package com.alonsogallego.rss_aggregator.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alonsogallego.rss_aggregator.databinding.FragmentRssManagementBinding

class RssManagementFragment: Fragment() {

    private var binding: FragmentRssManagementBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRssManagementBinding.inflate(inflater)
        return binding?.root
    }

}
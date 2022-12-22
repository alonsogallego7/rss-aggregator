package com.alonsogallego.rss_aggregator.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alonsogallego.rss_aggregator.R
import com.alonsogallego.rss_aggregator.databinding.FragmentRssManagementBinding

class RssManagementFragment: Fragment() {

    private var binding: FragmentRssManagementBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRssManagementBinding.inflate(inflater)

        binding!!.toolbarManagement.setOnMenuItemClickListener {
            if (it.itemId == R.id.action_save) {
                navigateToRssForm()
                true
            } else false
        }

        return binding?.root
    }

    private fun navigateToRssForm() {
        findNavController().navigate(
            RssManagementFragmentDirections.toRssform()
        )
    }

}
package com.alonsogallego.rss_aggregator.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.alonsogallego.rss_aggregator.R
import com.alonsogallego.rss_aggregator.databinding.FragmentRssManagementBinding
import com.alonsogallego.rss_aggregator.presentation.adapter.RssSourceAdapter

class RssManagementFragment: Fragment() {

    private var binding: FragmentRssManagementBinding? = null
    private val sourceRssAdapter = RssSourceAdapter()
    private val viewModel by lazy {
        RssFactory().getRssSourceListViewModel(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRssManagementBinding.inflate(inflater)

        binding!!.toolbarManagement.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_save -> {
                    navigateToBottomSheetSave()
                    true
                }
                else -> false
            }
        }

        setupView()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.loadSourceRss()
    }

    private fun setupView() {
        binding?.apply {
            rssSourceList.apply {
                adapter = sourceRssAdapter
                layoutManager =
                    LinearLayoutManager(
                        requireContext(),
                        LinearLayoutManager.VERTICAL,
                        false
                    )
            }
        }
    }

    private fun setupObservers() {
        val sourceRssListSubscriber =
            Observer<RssSourceListViewModel.SourceRssUiState> { uiState ->
                sourceRssAdapter.setDataItems(uiState.sourceRss)
            }
        viewModel.sourceRssListPublisher.observe(viewLifecycleOwner, sourceRssListSubscriber)
    }

    private fun navigateToBottomSheetSave() {
        findNavController().navigate(
            RssManagementFragmentDirections.toBottomsheetsave()
        )
    }

}
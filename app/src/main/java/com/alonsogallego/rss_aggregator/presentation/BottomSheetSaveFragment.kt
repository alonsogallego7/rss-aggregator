package com.alonsogallego.rss_aggregator.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.alonsogallego.rss_aggregator.databinding.FragmentBottomSheetSaveBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import java.util.Observer

class BottomSheetSaveFragment: BottomSheetDialogFragment() {

    private var viewModel: RssManagementViewModel? = null
    private var binding: FragmentBottomSheetSaveBinding? = null
    private var snackbar: Snackbar? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomSheetSaveBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = RssFactory().getRssManagementViewModel(
            requireContext()
        )
    }

    private fun setupObservers() {
        val rssManagementSubscriber =
            Observer<RssManagementViewModel.SourceRssUiState> {uiState ->
                if (uiSta)
            }
    }
}
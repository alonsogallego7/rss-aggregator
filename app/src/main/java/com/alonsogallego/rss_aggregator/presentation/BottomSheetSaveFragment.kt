package com.alonsogallego.rss_aggregator.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.alonsogallego.rss_aggregator.R
import com.alonsogallego.rss_aggregator.databinding.FragmentBottomSheetSaveBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar

class BottomSheetSaveFragment: BottomSheetDialogFragment() {

    private var viewModel: RssManagementViewModel? = null
    private var binding: FragmentBottomSheetSaveBinding? = null

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
        setupObservers()
        setupButtons()
    }

    private fun setupObservers() {
        val rssManagementSubscriber =
            Observer<RssManagementViewModel.SourceRssUiState> {uiState ->
                if(uiState.isSuccess) {
                    this.dismiss()
                    Snackbar.make(requireActivity().findViewById(R.id.main_view), getString(R.string.snackbar_saved_text), Snackbar.LENGTH_LONG).show()
                }
            }

        viewModel?.sourceRssPublisher?.observe(viewLifecycleOwner, rssManagementSubscriber)
    }

    private fun setupButtons() {
        binding?.buttonAdd?.setOnClickListener {
            viewModel?.saveSourceRss(binding?.nameTextInput?.text.toString(), binding?.urlTextInput?.text.toString())
        }

        binding?.buttonCancel?.setOnClickListener {
            this.dismiss()
        }
    }
}
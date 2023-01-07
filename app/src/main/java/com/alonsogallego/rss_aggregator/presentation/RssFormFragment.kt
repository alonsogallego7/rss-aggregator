package com.alonsogallego.rss_aggregator.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.alonsogallego.rss_aggregator.R
import com.alonsogallego.rss_aggregator.databinding.FragmentRssFormBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar

class RssFormFragment: BottomSheetDialogFragment() {

    private var viewModel: RssManagementViewModel? = null
    private var binding: FragmentRssFormBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRssFormBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = RssFactory().getRssManagementViewModel(
            requireContext()
        )
        setupButtons()
    }

    private fun setupObservers() {
        val rssManagementSubscriber =
            Observer<RssManagementViewModel.SourceRssUiState> {uiState ->
                Snackbar.make(requireActivity().findViewById(R.id.main_view),
                    if(uiState.isSuccess) {
                        getString(R.string.snackbar_saved_text)
                    } else {
                        getString(R.string.snackbar_not_saved_text)
                    },
                    Snackbar.LENGTH_LONG).show()
            }

        viewModel?.sourceRssPublisher?.observe(viewLifecycleOwner, rssManagementSubscriber)
    }

    private fun setupButtons() {
        binding?.buttonAdd?.setOnClickListener {
            viewModel?.saveSourceRss(binding?.nameTextInput?.text.toString(), binding?.urlTextInput?.text.toString())
            findNavController().navigateUp()
            setupObservers()
        }

        binding?.buttonCancel?.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
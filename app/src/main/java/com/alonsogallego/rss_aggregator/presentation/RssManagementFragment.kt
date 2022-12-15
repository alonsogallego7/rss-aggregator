package com.alonsogallego.rss_aggregator.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alonsogallego.rss_aggregator.R
import com.alonsogallego.rss_aggregator.databinding.FragmentRssManagementBinding
import com.google.android.material.snackbar.Snackbar

class RssManagementFragment: Fragment() {

    private var binding: FragmentRssManagementBinding? = null

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

        return binding?.root
    }

    fun setupSnackbar() {
        Snackbar.make(requireView(), "Guardado correctamente", Snackbar.LENGTH_LONG).show()
    }

    private fun navigateToBottomSheetSave() {
        findNavController().navigate(
            RssManagementFragmentDirections.toBottomsheetsave()
        )
    }

}
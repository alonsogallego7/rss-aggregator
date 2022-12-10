package com.alonsogallego.rss_aggregator.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alonsogallego.rss_aggregator.databinding.FragmentBottomSheetSaveBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetSaveFragment: BottomSheetDialogFragment() {

    private var binding: FragmentBottomSheetSaveBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomSheetSaveBinding.inflate(inflater)
        return binding?.root
    }
}
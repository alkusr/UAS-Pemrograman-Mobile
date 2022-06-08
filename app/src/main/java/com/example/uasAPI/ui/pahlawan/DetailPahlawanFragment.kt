package com.example.uasAPI.ui.pahlawan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.uasAPI.databinding.FragmentDetailPahlawanBinding
import com.example.uasAPI.ui.MyViewModel

class DetailPahlawanFragment : Fragment() {
    private val viewModel: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailPahlawanBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }
}
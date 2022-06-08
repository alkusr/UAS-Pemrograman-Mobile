package com.example.uasAPI.ui.penerbit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.uasAPI.databinding.FragmentDetailPenerbitBinding
import com.example.uasAPI.ui.MyViewModel

class DetailPenerbitFragment: Fragment() {
    private val myViewModel: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailPenerbitBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = myViewModel
        return binding.root
    }
}
package com.example.uasAPI.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.uasAPI.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }
}
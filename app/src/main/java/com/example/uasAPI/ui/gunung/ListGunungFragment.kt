package com.example.uasAPI.ui.gunung

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.uasAPI.R
import com.example.uasAPI.databinding.FragmentListGunungBinding
import com.example.uasAPI.ui.MyViewModel

class ListGunungFragment: Fragment() {
    private val myViewModel: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListGunungBinding.inflate(inflater)
        myViewModel.getGunungList()
        binding.lifecycleOwner = this
        binding.viewModel = myViewModel
        binding.recyclerView.adapter = GunungListAdapter(GunungListener { gunung ->
            myViewModel.onGunungCLicked(gunung)
            findNavController()
                .navigate(R.id.action_listGunungFragment_to_detailGunungFragment)
        })
        return binding.root
    }


}
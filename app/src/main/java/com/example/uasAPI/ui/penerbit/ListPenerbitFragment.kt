package com.example.uasAPI.ui.penerbit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.uasAPI.R
import com.example.uasAPI.databinding.FragmentListPenerbitBinding
import com.example.uasAPI.ui.MyViewModel

class ListPenerbitFragment: Fragment() {
    private val myViewModel: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListPenerbitBinding.inflate(inflater)
        myViewModel.getPenerbitList()
        binding.lifecycleOwner = this
        binding.viewModel = myViewModel
        binding.recyclerView.adapter = PenerbitListAdapter(PenerbitListener { penerbit ->
            myViewModel.onPenerbitCLicked(penerbit)
            findNavController()
                .navigate(R.id.action_listPenerbitFragment_to_detailPenerbitFragment)
        })
        return binding.root
    }


}
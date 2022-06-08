package com.example.uasAPI.ui.pahlawan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.uasAPI.R
import com.example.uasAPI.databinding.FragmentListPahlawanBinding
import com.example.uasAPI.ui.PahlawanListAdapter
import com.example.uasAPI.ui.PahlawanListener
import com.example.uasAPI.ui.MyViewModel

class ListPahlawanFragment : Fragment() {
    private val viewModel: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListPahlawanBinding.inflate(inflater)
        viewModel.getPahlawanList()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = PahlawanListAdapter(PahlawanListener { pahlawan ->
            viewModel.onPahlawanCLicked(pahlawan)
            findNavController()
                .navigate(R.id.action_listPahlawanFragment_to_detailPahlawanFragment)
        })
        return binding.root
    }

}
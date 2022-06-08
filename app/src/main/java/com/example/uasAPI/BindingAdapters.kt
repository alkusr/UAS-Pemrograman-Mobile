package com.example.uasAPI

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout
import com.example.uasAPI.network.Gunung
import com.example.uasAPI.network.Penerbit
import com.example.uasAPI.network.Pahlawan
import com.example.uasAPI.ui.ApiStatus
import com.example.uasAPI.ui.gunung.GunungListAdapter
import com.example.uasAPI.ui.PahlawanListAdapter
import com.example.uasAPI.ui.penerbit.PenerbitListAdapter


@BindingAdapter("listData")
fun bindRecyclerViewPahlawan(recyclerView: RecyclerView, data: List<Pahlawan>?) {
    val adapter = recyclerView.adapter as PahlawanListAdapter
    adapter.submitList(data)
}
@BindingAdapter("listDataGunung")
fun bindRecyclerViewGunung(recyclerView: RecyclerView, data: List<Gunung>?) {
    val adapter = recyclerView.adapter as GunungListAdapter
    adapter.submitList(data)
}
@BindingAdapter("listDataPenerbit")
fun bindRecyclerViewPenerbit(recyclerView: RecyclerView, data: List<Penerbit>?) {
    val adapter = recyclerView.adapter as PenerbitListAdapter
    adapter.submitList(data)
}

@BindingAdapter("apiStatus")
fun apiStatus(shimmerFrameLayout: ShimmerFrameLayout, status: ApiStatus?){
    when(status){
        ApiStatus.DONE->{
            shimmerFrameLayout.stopShimmer()
            shimmerFrameLayout.visibility = View.GONE
        }
    }
}
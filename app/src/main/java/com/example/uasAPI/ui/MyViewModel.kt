package com.example.uasAPI.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uasAPI.network.Gunung
import com.example.uasAPI.network.Penerbit
import com.example.uasAPI.network.Pahlawan
import com.example.uasAPI.network.UasAPIApi
import kotlinx.coroutines.launch
import java.lang.Exception

enum class ApiStatus { LOADING, ERROR, DONE }

class MyViewModel : ViewModel() {
    // status
    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus> = _status

    // penampung data untuk API doa
    private val _listpahlawan = MutableLiveData<List<Pahlawan>>()
    val listpahlawan: LiveData<List<Pahlawan>> = _listpahlawan

    private val _pahlawantunggal = MutableLiveData<Pahlawan>()
    val pahlawantunggal: LiveData<Pahlawan> = _pahlawantunggal

    // penampung data untuk API gunung
    private val _listgunung = MutableLiveData<List<Gunung>>()
    val listgunung: LiveData<List<Gunung>> = _listgunung

    private val _gunungTunggal = MutableLiveData<Gunung>()
    val gunungTunggal: LiveData<Gunung> = _gunungTunggal

    // penampung data untuk API penerbit
    private val _listpenerbit = MutableLiveData<List<Penerbit>>()
    val listpenerbit: LiveData<List<Penerbit>> = _listpenerbit

    private val _penerbitTunggal = MutableLiveData<Penerbit>()
    val penerbitTunggal: LiveData<Penerbit> = _penerbitTunggal




    fun getPahlawanList() {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
                _listpahlawan.value = UasAPIApi.retrofitServiceApi.getPahlawan()
                _status.value = ApiStatus.DONE
            } catch (e: Exception) {
                Log.d("error", e.printStackTrace().toString())
                _listpahlawan.value = listOf()
                _status.value = ApiStatus.ERROR
            }
        }
    }

    fun getGunungList(){
        viewModelScope.launch {
            try {
                _listgunung.value = UasAPIApi.retrofitServiceApi.getGunung()
                _status.value = ApiStatus.DONE
            } catch (e: Exception) {
                Log.d("error", e.printStackTrace().toString())
                _listgunung.value = listOf()
                _status.value = ApiStatus.ERROR
            }
        }
    }

    fun getPenerbitList(){
        viewModelScope.launch {
            try {
                _listpenerbit.value = UasAPIApi.retrofitServiceApi.getPenerbit()
                _status.value = ApiStatus.DONE
            } catch (e: Exception) {
                Log.d("error", e.printStackTrace().toString())
                _listpenerbit.value = listOf()
                _status.value = ApiStatus.ERROR
            }
        }
    }

    fun onPahlawanCLicked(pahlawan: Pahlawan){
        _pahlawantunggal.value = pahlawan
    }

    fun onGunungCLicked(gunung: Gunung){
        _gunungTunggal.value = gunung
    }

    fun onPenerbitCLicked(penerbit: Penerbit){
        _penerbitTunggal.value = penerbit
    }
}
package com.example.ksbaodemo.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ksbaodemo.data.KsbClass
import com.example.ksbaodemo.extensions.NetResult
import com.example.ksbaodemo.repo.KsbRepo
import kotlinx.coroutines.launch

class KsbViewModel(val ksbRepo: KsbRepo) : ViewModel() {

    val ksbClass = MutableLiveData<KsbClass?>()

    val ksbClassWithHot = MutableLiveData<KsbClass?>()

    val hasError = MutableLiveData(false)

    fun fetchKsbClass() {
        fetchData(false)
    }

    fun fetchKsbClassWithHot() {
        fetchData(true)
    }

    init {
        fetchKsbClass()
    }

    private fun fetchData(isHot: Boolean) {
        viewModelScope.launch {
            when (val result = ksbRepo.fetchKsbClass(isHot)) {
                is NetResult.Success -> {
                    hasError.postValue(false)
                    if (isHot) {
                        ksbClassWithHot.postValue(result.data)
                    } else {
                        ksbClass.postValue(result.data)
                    }
                }
                is NetResult.Error -> {
                    hasError.postValue(true)
                    Log.e("ERROR", result.e.message.toString())
                }
            }
        }
    }
}
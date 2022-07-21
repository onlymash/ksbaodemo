package com.example.ksbaodemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.ksbaodemo.extensions.getViewModel
import com.example.ksbaodemo.repo.KsbRepo


fun ViewModelStoreOwner.getKsbViewModel(repo: KsbRepo): KsbViewModel =
    getViewModel(object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return KsbViewModel(repo) as T
        }
    })
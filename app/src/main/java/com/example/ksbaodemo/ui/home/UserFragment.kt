package com.example.ksbaodemo.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ksbaodemo.databinding.FragmentUserBinding
import com.example.ksbaodemo.ui.base.BindingFragment

class UserFragment : BindingFragment<FragmentUserBinding>() {

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentUserBinding {
        return FragmentUserBinding.inflate(inflater, container, false)
    }
}
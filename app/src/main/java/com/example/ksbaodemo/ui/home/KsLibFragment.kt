package com.example.ksbaodemo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.ksbaodemo.R
import com.example.ksbaodemo.databinding.FragmentKsLibBinding
import com.example.ksbaodemo.ui.base.BindingFragment

class KsLibFragment : BindingFragment<FragmentKsLibBinding>() {

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentKsLibBinding {
        return FragmentKsLibBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ksClassBtn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_open_ks_class)
        }
    }
}
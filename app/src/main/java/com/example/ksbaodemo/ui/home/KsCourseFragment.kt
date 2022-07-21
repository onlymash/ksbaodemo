package com.example.ksbaodemo.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ksbaodemo.databinding.FragmentKsCourseBinding
import com.example.ksbaodemo.ui.base.BindingFragment

class KsCourseFragment : BindingFragment<FragmentKsCourseBinding>() {
    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentKsCourseBinding {
        return FragmentKsCourseBinding.inflate(inflater, container, false)
    }
}
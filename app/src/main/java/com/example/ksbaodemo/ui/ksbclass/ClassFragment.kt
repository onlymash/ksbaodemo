package com.example.ksbaodemo.ui.ksbclass

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.ksbaodemo.data.Child
import com.example.ksbaodemo.databinding.FragmentClassListBinding
import com.example.ksbaodemo.ui.base.BindingFragment


class ClassFragment : BindingFragment<FragmentClassListBinding>() {

    private var childs: List<Child> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { args ->
            ClassFragmentArgs.fromBundle(args).childs?.let {
                childs = it.toList()
            }
        }
    }

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentClassListBinding {
        return FragmentClassListBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.list.adapter = MyClassItemRecyclerViewAdapter(childs) {
            Navigation.findNavController(view)
                .navigate(ClassFragmentDirections.actionOpenKsClassList(it.toTypedArray()))
        }
    }
}
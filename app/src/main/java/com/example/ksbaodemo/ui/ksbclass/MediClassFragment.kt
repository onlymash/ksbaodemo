package com.example.ksbaodemo.ui.ksbclass

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import com.example.ksbaodemo.api.KsbaoApi
import com.example.ksbaodemo.databinding.FragmentMediClassListBinding
import com.example.ksbaodemo.repo.KsbRepoImpl
import com.example.ksbaodemo.ui.base.BindingFragment
import com.example.ksbaodemo.viewmodel.getKsbViewModel

class MediClassFragment : BindingFragment<FragmentMediClassListBinding>() {


    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMediClassListBinding {
        return FragmentMediClassListBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MyMediClassItemRecyclerViewAdapter() {
            Navigation.findNavController(view).navigate(MediClassFragmentDirections.actionOpenKsClassList(it.toTypedArray()))
        }
        binding.mediList.adapter = adapter
        val ksbViewModel = getKsbViewModel(KsbRepoImpl(KsbaoApi.createApi()))
        ksbViewModel.hasError.observe(viewLifecycleOwner) { hasError ->
            if (hasError) {
                binding.mediList.isVisible = false
                binding.retry.isVisible = true
                binding.progressCircular.isVisible = false



            } else {
                binding.mediList.isVisible = true
                binding.retry.isVisible = false
            }
        }
        ksbViewModel.ksbClass.observe(viewLifecycleOwner) { ksbClass ->
            if (ksbClass != null) {
                binding.progressCircular.isVisible = false
            }
            adapter.bindData(ksbClass)
        }
        binding.retry.setOnClickListener {
            binding.progressCircular.isVisible = true
            binding.retry.isVisible = false
            ksbViewModel.fetchKsbClass()
        }
    }
}
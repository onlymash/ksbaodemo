package com.example.ksbaodemo.ui.ksbclass

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ksbaodemo.data.Child
import com.example.ksbaodemo.data.KsbClass
import com.example.ksbaodemo.data.Medata
import com.example.ksbaodemo.databinding.FragmentMediClassBinding

class MyMediClassItemRecyclerViewAdapter(
    private val clickCallback:(List<Child>) -> Unit
) : RecyclerView.Adapter<MyMediClassItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentMediClassBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    private var _ksbClass: KsbClass? = null
    private val medata get() = _ksbClass!!.medata

    private fun getChilds(mediClassID: Int) : List<Child> {
        return _ksbClass!!.data.filter { it.mediClassID == mediClassID }
    }

    fun bindData(ksbClass: KsbClass?) {
        _ksbClass = ksbClass
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val medi = medata[position]
        holder.bindData(medi)
        holder.itemView.setOnClickListener {
            clickCallback(getChilds(medi.mediClassID))
        }
    }

    override fun getItemCount(): Int = _ksbClass?.medata?.size ?: 0

    inner class ViewHolder(binding: FragmentMediClassBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val mediTitleView = binding.mediTitle
        private val mediRemarkView = binding.mediRemark
        fun bindData(medi: Medata) {
            mediTitleView.text = medi.title
            mediRemarkView.text = medi.remark
        }
    }

}
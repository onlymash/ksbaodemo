package com.example.ksbaodemo.ui.ksbclass

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.example.ksbaodemo.data.Child
import com.example.ksbaodemo.databinding.FragmentClassBinding

class MyClassItemRecyclerViewAdapter(
    private val childs: List<Child>,
    private val clickCallback:(List<Child>) -> Unit
) : RecyclerView.Adapter<MyClassItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentClassBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val child = childs[position]
        holder.bind(child)
        holder.itemView.setOnClickListener {
            val subChilds = child.childs
            if (subChilds.isNullOrEmpty()) {
                Toast.makeText(holder.itemView.context, "childs is null", Toast.LENGTH_SHORT).show()
            } else {
                clickCallback(subChilds)
            }
        }

    }

    override fun getItemCount(): Int = childs.size

    inner class ViewHolder(binding: FragmentClassBinding) : RecyclerView.ViewHolder(binding.root) {
        private val classNameView = binding.className
        fun bind(child: Child) {
            classNameView.text = child.ksbClassName
        }
    }

}
package com.afhapps.uihomework.tablayout.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afhapps.uihomework.databinding.ItemTablayoutBinding

class ViewPagerTabLayoutAdapter (var img: List<Int>):RecyclerView.Adapter<ViewPagerTabLayoutAdapter.TabLayoutViewHolder>() {
    inner class TabLayoutViewHolder (val binding:ItemTablayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TabLayoutViewHolder {
        return TabLayoutViewHolder(ItemTablayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: TabLayoutViewHolder, position: Int) {
            holder.binding.imageView4.setImageResource(img[position ])
    }

    override fun getItemCount(): Int {
        return img.size
    }


}
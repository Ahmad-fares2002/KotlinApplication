package com.afhapps.uihomework.notes.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afhapps.uihomework.databinding.ItemNoteslistBinding

class NotesAdapter(val text:List<String>):RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {
    inner class NotesViewHolder(val binding:ItemNoteslistBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(ItemNoteslistBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.binding.tvnotes.text = text[position]
    }

    override fun getItemCount(): Int {
        return text.count()
    }


}
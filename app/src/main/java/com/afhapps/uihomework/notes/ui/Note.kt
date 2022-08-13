package com.afhapps.uihomework.notes.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.afhapps.uihomework.databinding.ActivityNoteBinding
import com.afhapps.uihomework.notes.model.NotesAdapter

class Note : Fragment() {
    private lateinit var binding: ActivityNoteBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityNoteBinding.inflate(inflater,container,false)
        val notesItem = mutableListOf<String>("Lorem")
        val adapter = NotesAdapter(notesItem)
        binding.rvnotes.adapter = adapter
        binding.rvnotes.layoutManager = LinearLayoutManager(activity)




        binding.btnotes.setOnClickListener {
            var text = binding.etnotes.text.toString()
            notesItem.add(text)
            adapter.notifyDataSetChanged()
            binding.etnotes.text?.clear()
        }
        return binding.root
    }
}
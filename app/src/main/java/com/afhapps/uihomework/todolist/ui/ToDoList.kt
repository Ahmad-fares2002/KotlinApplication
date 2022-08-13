package com.afhapps.uihomework.todolist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager


import com.afhapps.start.todolist.model.ToDo
import com.afhapps.start.todolist.utils.ToDoAdapter
import com.afhapps.uihomework.R
import com.afhapps.uihomework.databinding.ActivityToDoListBinding
class TodoList:Fragment(R.layout.activity_to_do_list){
    private lateinit var binding: ActivityToDoListBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = ActivityToDoListBinding.inflate(inflater,container,false)

        val view = binding.root
        val toDoListSingleItem = mutableListOf(ToDo("Go to Gym",false))
        val adapter = ToDoAdapter(toDoListSingleItem)
        binding.rvToDo.adapter = adapter
        binding.rvToDo.layoutManager = LinearLayoutManager(activity)

        binding.btaddtodo.setOnClickListener {
            var text = binding.edtodo.text.toString()
            var newToDo= ToDo(text,false)
            toDoListSingleItem.add(newToDo)
            adapter.notifyDataSetChanged()
            binding.edtodo.text.clear()
        }

        return view
    }
}

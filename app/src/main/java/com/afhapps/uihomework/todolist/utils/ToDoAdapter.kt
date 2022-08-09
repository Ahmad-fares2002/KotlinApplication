package com.afhapps.start.todolist.utils


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.*

import com.afhapps.start.todolist.model.ToDo
import com.afhapps.uihomework.databinding.ItemTodoBinding

class ToDoAdapter(var todos:List<ToDo>) : Adapter<ToDoAdapter.ToDoViewHolder>() {
    inner class ToDoViewHolder(val binding: ItemTodoBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        return ToDoViewHolder(ItemTodoBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.binding.apply {
            tvtodotitle.text = todos[position].title
            chkToDoDone.isChecked = todos[position].isChecked
        }
    }

    override fun getItemCount(): Int {
    return todos.size
    }

}
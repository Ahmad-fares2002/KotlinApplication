package com.afhapps.uihomework.bottomnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.afhapps.uihomework.todolist.ui.TodoList
import com.afhapps.uihomework.R
import com.afhapps.uihomework.counter.CounterActivity
import com.afhapps.uihomework.databinding.ActivityHomeBinding
import com.afhapps.uihomework.resturant.ResturantActivity
import com.afhapps.uihomework.tablayout.ui.TabLayout

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCurrentFragment(TodoList())
        binding.bnView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.todolist->setCurrentFragment(TodoList())
                R.id.resturant->setCurrentFragment(ResturantActivity())
                R.id.counter->setCurrentFragment(CounterActivity())
                R.id.calculator->setCurrentFragment(Calculator())
                R.id.tab->setCurrentFragment(TabLayout())
            }
            true
        }

    }
    fun setCurrentFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentcontainer,fragment)
            commit()

        }
    }
}
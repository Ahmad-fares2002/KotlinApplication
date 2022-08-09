package com.afhapps.uihomework.tablayout.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.afhapps.uihomework.R
import com.afhapps.uihomework.databinding.ActivityTabLayoutBinding
import com.afhapps.uihomework.tablayout.utils.ViewPagerTabLayoutAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.*

class TabLayout : Fragment() {
    private lateinit var binding: ActivityTabLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityTabLayoutBinding.inflate(inflater,container,false)
       val images = listOf(R.drawable.logo2,R.drawable.logo3,R.drawable.logo4,R.drawable.logo5)
        val adapter = ViewPagerTabLayoutAdapter(images)
        binding.vptablyout.adapter = adapter
        TabLayoutMediator(binding.tl,binding.vptablyout){tabLayout,pos->
        tabLayout.text = "tab${pos+1}"
        }.attach()

        binding.tl.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(activity,"Tab ${tab?.position}  is selected",Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(activity,"Tab ${tab?.position}  is Unselected",Toast.LENGTH_SHORT).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(activity,"Tab ${tab?.position}  is Reselected",Toast.LENGTH_SHORT).show()
            }


        })
        return binding.root

    }
}

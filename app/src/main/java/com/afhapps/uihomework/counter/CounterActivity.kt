package com.afhapps.uihomework.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.afhapps.uihomework.R
import com.afhapps.uihomework.databinding.ActivityCounterBinding

class CounterActivity : Fragment(R.layout.activity_counter) {
    private lateinit var binding: ActivityCounterBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityCounterBinding.inflate(inflater,container,false)
        val view = binding.root
        var count =0

        binding.btadd.setOnClickListener {
            if(count == 0)
                binding.tvcounterwarn.text = ""
            count++
            binding.tvcounternumber.text = "$count"
        }
        binding.btsubtract.setOnClickListener {
            if (count>0)
                count--
            else
                binding.tvcounterwarn.text = "The number must be more than 0"
            binding.tvcounternumber.text = "$count"
        }
        return view
    }

}

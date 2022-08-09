package com.afhapps.uihomework.bottomnav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.afhapps.uihomework.R
import com.afhapps.uihomework.databinding.FragmentCalculatorBinding


class Calculator : Fragment(R.layout.fragment_calculator) {


    private lateinit var binding: FragmentCalculatorBinding

     override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        val view = binding.root
        var fnum: Double = 0.0
        var lnum: Double = 0.0
        var result: Double


        binding.plus.setOnClickListener {
            if (binding.fnum.text.isNotEmpty() && binding.lnum.text.isNotEmpty()) {
                fnum = binding.fnum.text.toString().toDouble()
                lnum = binding.lnum.text.toString().toDouble()



                result = fnum + lnum
                binding.result.text = result.toString()
            }

        }

        binding.minus.setOnClickListener {
            if (binding.fnum.text.isNotEmpty() && binding.lnum.text.isNotEmpty()) {
                fnum = binding.fnum.text.toString().toDouble()
                lnum = binding.lnum.text.toString().toDouble()

                result = fnum - lnum
                binding.result.text = result.toString()
            }
        }

        binding.multi.setOnClickListener {
            if (binding.fnum.text.isNotEmpty() && binding.lnum.text.isNotEmpty()) {
                fnum = binding.fnum.text.toString().toDouble()
                lnum = binding.lnum.text.toString().toDouble()

                result = fnum * lnum
                binding.result.text = result.toString()
            }
        }

        binding.division.setOnClickListener {
            if (binding.fnum.text.isNotEmpty() && binding.lnum.text.isNotEmpty()) {
                fnum = binding.fnum.text.toString().toDouble()
                lnum = binding.lnum.text.toString().toDouble()

                result = fnum / lnum
                binding.result.text = result.toString()
            }
        }
         binding.reset.setOnClickListener{
             binding.lnum.text.clear()
             binding.fnum.text.clear()
             binding.result.setText("")

         }


        return view
    }


}
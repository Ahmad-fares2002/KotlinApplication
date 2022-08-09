package com.afhapps.uihomework.resturant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import com.afhapps.uihomework.R
import com.afhapps.uihomework.databinding.ActivityResturantBinding

class ResturantActivity : Fragment(R.layout.activity_resturant) {
    private lateinit var binding: ActivityResturantBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityResturantBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.btorder.setOnClickListener {
            val checkedRadioId = binding.radioGroup.checkedRadioButtonId
            val checkedRadio = view?.findViewById<RadioButton>(checkedRadioId)
            var result = "Your Chose the alphabet ${checkedRadio?.text} " +
                    "and the item " +
                    (if (binding.pizza.isChecked) "pizza " else "") +
                    (if (binding.burger.isChecked) "burger " else "") +
                    (if (binding.fries.isChecked) "fries " else "")
            binding.tvorder.text = result

        }
        return view
    }
}

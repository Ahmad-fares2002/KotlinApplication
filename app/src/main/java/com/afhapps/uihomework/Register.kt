package com.afhapps.uihomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.afhapps.uihomework.databinding.ActivityRegisterBinding
import android.content.Intent
import com.afhapps.uihomework.bottomnav.HomeActivity
import com.afhapps.uihomework.nav.BaseActivity


class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnregister.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
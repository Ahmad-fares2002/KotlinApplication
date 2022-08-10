package com.afhapps.uihomework

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.afhapps.uihomework.databinding.ActivityMainBinding

import com.afhapps.uihomework.nav.BaseActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()


        val sharedPreference = getSharedPreferences("loginFile", 0)
        val editSharePreference = sharedPreference.edit()

        // read the data
        binding.edemail.setText(sharedPreference.getString("userName", null))
        binding.password.setText(sharedPreference.getString("password", null))
        binding.cbremmberme.isChecked = sharedPreference.getBoolean("ischecked", false)


        // write
        binding.cbremmberme.setOnClickListener {

            val username = binding.edemail.text.toString()
            val password = binding.password.text.toString()
            val isChecked = binding.cbremmberme.isChecked
            editSharePreference.apply {
                putString("userName", username)
                putString("password", password)
                putBoolean("ischecked", isChecked)
                apply()
            }
            Toast.makeText(this,"Saved succefully",Toast.LENGTH_SHORT).show()
        }

        var status: Boolean
        binding.showpassword.setOnClickListener {
            var status = binding.password.transformationMethod
            if (status == HideReturnsTransformationMethod.getInstance())
                binding.password.transformationMethod = PasswordTransformationMethod.getInstance()
            else
                binding.password.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()

        }
        binding.button.setOnClickListener {
            val user = binding.edemail.text.toString()
            val pass = binding.password.text.toString()
            status = false
            for (i in 0..user.length - 1) {
                var n: Char = user[i];
                if (n == ' ') {
                    status = true
                }
            }
            if (user.length < 3 || status) {

                Toast.makeText(
                    this,
                    "Stop doing that, the name is less than 3 or it has spaces",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (pass.length < 5) {
                Toast.makeText(
                    this, "pass is less than 5 char", Toast.LENGTH_SHORT
                ).show()
            } else {
                val intent = Intent(this, BaseActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
        binding.tvhaveanaccount.setOnClickListener() {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
            finish()
            Log.d("Ahmad","Dont go out")

        }
    }

}
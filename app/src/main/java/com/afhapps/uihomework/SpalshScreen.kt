package com.afhapps.uihomework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.afhapps.uihomework.bottomnav.HomeActivity
import com.afhapps.uihomework.coroutines.Coroutine
import com.afhapps.uihomework.counter.CounterActivity
import com.afhapps.uihomework.resturant.ResturantActivity

@Suppress("DEPRECATION")
class SpalshScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalsh_screen)
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
            //ahmad fares
        }, 3000)
    }
}
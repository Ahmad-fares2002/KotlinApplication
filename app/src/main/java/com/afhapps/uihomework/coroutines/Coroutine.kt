package com.afhapps.uihomework.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import com.afhapps.uihomework.R
import com.afhapps.uihomework.databinding.ActivityCoroutineBinding
import kotlinx.coroutines.*

class Coroutine : AppCompatActivity() {
    private lateinit var binding: ActivityCoroutineBinding
    override fun onCreate(savedInstanceState: Bundle?) {
     binding = ActivityCoroutineBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val Tag = "coroutines"

        GlobalScope.launch(Dispatchers.Main) {


            var result2: String? = null
            var result1: String? = null
        val job1 = launch{
             result1 = postDelay1()
        }
        val job2 = launch{
             result2 = postDelay2()
        }
            Log.d(Tag,"This is the BAD ONE ")
            job1.join()
            job2.join()
            Log.d(Tag,"This is the first one $result1 ")
            Log.d(Tag,"This is the second one $result2 ")

        }



    }
    suspend fun postDelay1() :String{
        delay(5000L)
        return "Ahmad Fares Abu Hajeer1"
    }

    suspend fun postDelay2() :String{
        delay(5000L)
        return "Ahmad Fares Abu Hajeer2"
    }
}
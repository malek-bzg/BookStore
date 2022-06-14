package com.example.examen

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    lateinit var mSharedPref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lateinit var handler: Handler
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        //splash screen 3s
        handler= Handler()
        handler.postDelayed({
            val intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
    }

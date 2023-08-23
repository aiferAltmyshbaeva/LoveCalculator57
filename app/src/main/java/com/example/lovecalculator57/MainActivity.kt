package com.example.lovecalculator57

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lovecalculator57.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .add(com.google.android.material.R.id.container, StartFragment())
            .addToBackStack(null).commit()
    }

}
package com.example.lovecalculator57.ui.onboarding

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lovecalculator57.R
import com.example.lovecalculator57.databinding.ActivityOnBoardingBinding
import com.example.lovecalculator57.ui.MainActivity
import com.example.lovecalculator57.ui.onboarding.adapter.OnBoardingAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingActivity : AppCompatActivity(R.layout.activity_on_boarding) {

    private val binding: ActivityOnBoardingBinding by viewBinding()
    private val adapter = OnBoardingAdapter(this::onClick)

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewPager.adapter = adapter
        binding.indicator.setViewPager(binding.viewPager)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)

    }

    private fun onClick() {
        sharedPreferences.edit().putBoolean("is_first_run", false).apply()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
package com.example.lovecalculator57.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lovecalculator57.App
import com.example.lovecalculator57.R
import com.example.lovecalculator57.databinding.ActivityHistoryBinding
import com.example.lovecalculator57.model.room.AppDatabase

class HistoryActivity : AppCompatActivity(R.layout.activity_history) {
    private val binding: ActivityHistoryBinding by viewBinding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupUI()
    }

    @SuppressLint("SetTextI18n")
    private fun setupUI() {
        val list = App.appDatabase.loveDao().getAll()
        list.forEach {
            binding.historyTv.append(
                "${it.firstName} \n ${it.secondName} \n ${it.percentage} \n ${it.result} \n ------------ \n")
        }
    }
}
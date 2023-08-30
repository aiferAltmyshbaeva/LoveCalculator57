package com.example.lovecalculator57.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lovecalculator57.R
import com.example.lovecalculator57.ResultPresenter
import com.example.lovecalculator57.databinding.ActivitySecondBinding
import com.example.lovecalculator57.model.LoveModel
import com.example.lovecalculator57.utils.changeScreen
import com.example.lovecalculator57.view.ResultView

class SecondActivity : AppCompatActivity(R.layout.activity_second), ResultView {

    private val binding: ActivitySecondBinding by viewBinding()
    private val presenter = ResultPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initClickers()
        setupUI()
    }

    private fun initClickers() {
        with(binding) {
            historyBtn.setOnClickListener {
                changeScreen(HistoryActivity(), null)
            }
        }
    }

    private fun setupUI() {
        val result = intent.getSerializableExtra("key") as LoveModel
        presenter.getData(result)
    }

    override fun showLove(
        firstName: String,
        secondName: String,
        percentage: String,
        result: String
    ) {
        with(binding) {
            tvFname.text = firstName
            tvSname.text = secondName
            tvPercentage.text = percentage
            tvResult.text = result
            tryAgainBtn.setOnClickListener { onBackPressed() }
        }
    }
}
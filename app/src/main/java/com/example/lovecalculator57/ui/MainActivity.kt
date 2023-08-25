package com.example.lovecalculator57.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lovecalculator57.Presenter
import com.example.lovecalculator57.R
import com.example.lovecalculator57.databinding.ActivityMainBinding
import com.example.lovecalculator57.model.LoveModel
import com.example.lovecalculator57.utils.changeScreen
import com.example.lovecalculator57.view.LoveView

class MainActivity : AppCompatActivity(R.layout.activity_main), LoveView {

    private val binding: ActivityMainBinding by viewBinding()
    private val presenter = Presenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            calculateBtn.setOnClickListener {
                presenter.getLoveResult(firstEd.text.toString(), secondEd.text.toString())
            }
        }
    }

    override fun navigationToResultScreen(loveModel: LoveModel) {
        changeScreen(SecondActivity(), loveModel, "key")
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }
}
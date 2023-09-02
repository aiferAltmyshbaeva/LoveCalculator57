package com.example.lovecalculator57.ui

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lovecalculator57.App
import com.example.lovecalculator57.Presenter
import com.example.lovecalculator57.R
import com.example.lovecalculator57.databinding.ActivityMainBinding
import com.example.lovecalculator57.model.LoveModel
import com.example.lovecalculator57.ui.onboarding.OnBoardingActivity
import com.example.lovecalculator57.utils.changeScreen
import com.example.lovecalculator57.view.LoveView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main), LoveView {

    private val binding: ActivityMainBinding by viewBinding()

    @Inject
    lateinit var presenter: Presenter

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
        initClickers()

        val isFirstRun = sharedPreferences.getBoolean("is_first_run", true)

        if (isFirstRun) {
            sharedPreferences.edit().putBoolean("is_first_run", false).apply()
            startActivity(Intent(this, OnBoardingActivity::class.java))
            finish()
        }
    }

    private fun initClickers() {
        with(binding) {
            calculateBtn.setOnClickListener {
                presenter.getLoveResult(firstEd.text.toString(), secondEd.text.toString())
            }
        }
    }

    override fun navigationToResultScreen(loveModel: LoveModel) {
        App.appDatabase.loveDao().insert(loveModel)
        changeScreen(SecondActivity(), loveModel, "key")
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

}
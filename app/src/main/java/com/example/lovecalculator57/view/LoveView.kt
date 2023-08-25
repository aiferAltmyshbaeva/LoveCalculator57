package com.example.lovecalculator57.view

import com.example.lovecalculator57.model.LoveModel

interface LoveView {

    fun navigationToResultScreen(loveModel: LoveModel)
    fun showError(error: String)

}
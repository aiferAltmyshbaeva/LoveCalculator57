package com.example.lovecalculator57

import com.example.lovecalculator57.model.LoveModel
import com.example.lovecalculator57.view.ResultView

class ResultPresenter(private val resultView: ResultView) {

    fun getData(loveModel: LoveModel) {
        resultView.showLove(
            loveModel.firstName,
            loveModel.secondName,
            loveModel.percentage,
            loveModel.result
        )
    }

}
package com.example.lovecalculator57.utils

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import java.io.Serializable

fun <T : Serializable> Activity.changeScreen(toActivity: Activity, model: T, key: String) {
    val intent = Intent(this, toActivity::class.java)
    val bundle = Bundle()
    bundle.putSerializable(key, model)
    intent.putExtras(bundle)
    startActivity(intent)
}
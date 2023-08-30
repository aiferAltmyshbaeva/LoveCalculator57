package com.example.lovecalculator57.utils

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import java.io.Serializable

fun <T : Serializable> Activity.changeScreen(
    toActivity: Activity,
    model: T? = null,
    key: String? = null
) {
    val intent = Intent(this, toActivity::class.java)

    if (!key.isNullOrEmpty()) {
        val bundle = Bundle()
        bundle.putSerializable(key, model)
        intent.putExtras(bundle)
    }
    startActivity(intent)
}
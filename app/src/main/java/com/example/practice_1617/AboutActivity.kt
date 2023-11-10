package com.example.practice_1617

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about2)

        setTitle("О программе")
    }

    fun ButtonClick(view: View) {
        finish()
    }
}
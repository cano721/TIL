package com.example.basicview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_progress_bar_test.*

class ProgressBarTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_bar_test)
        btngetValue.setOnClickListener {
            txtdisplay.text = "현재값:${progressBar3.progress}"
        }

        btnset.setOnClickListener {
            progressBar3.progress = 89
        }
        btnup.setOnClickListener {
            progressBar3.incrementProgressBy(10)
        }
        btndown.setOnClickListener {
            progressBar3.incrementProgressBy(-10)
        }
        btnstart.setOnClickListener {
            while(progressBar4.progress < 100) {
                progressBar4.incrementProgressBy(5)
            }
        }
    }
}
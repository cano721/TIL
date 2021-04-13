package com.example.iot.sensor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.iot.R
import kotlinx.android.synthetic.main.activity_detection.*

class DetectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detection)
        camera_view.apply{
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
        }

        camera_view.loadUrl("http://172.30.1.47:5000/on")
    }
}
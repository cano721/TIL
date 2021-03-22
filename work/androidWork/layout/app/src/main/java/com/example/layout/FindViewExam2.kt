package com.example.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_find_view_exam2.*

class FindViewExam2 : AppCompatActivity(),View.OnClickListener {
    var btn:Button? = null
    var img:ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_view_exam2)
        btn = findViewById(R.id.btnDream1)
        btn?.setOnClickListener(this)

        btnDream2.setOnClickListener {
            mainImg.setImageResource(R.drawable.dream02)
        }
        btnBeach.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                mainImg.setImageResource(R.drawable.beach)
            }

        })
        val launch_bg = object :View.OnClickListener{
            override fun onClick(v: View?) {
                mainImg.setImageResource(R.drawable.ic_launcher_background)
            }

        }
        ic_lb.setOnClickListener(launch_bg)
    }

    override fun onClick(v: View?) {
        mainImg.setImageResource(R.drawable.dream01)
    }
}
package com.example.permissionpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.use_custom_permission.*

class UserCustomPermission : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.use_custom_permission)
        button.setOnClickListener {
            useApp(it) //it은 click이벤트를 발생시킨 객체 => 버튼,이미지,텍스트뷰 ....
        }
    }
    fun useApp(v: View){
        val myintent = Intent("com.exam.selectview")
        startActivity(myintent)
    }
}
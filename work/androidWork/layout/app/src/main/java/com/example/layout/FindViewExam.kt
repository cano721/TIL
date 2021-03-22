package com.example.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class FindViewExam : AppCompatActivity(),View.OnClickListener{
    var btn: Button?=null
    var result: TextView?=null
    var data: TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.findview_exam)
        btn = findViewById(R.id.btnMove)
        result = findViewById(R.id.exam_result)
        data = findViewById(R.id.data)
        btn?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        //1. data텍스트뷰의 문자열을 읽어오기
        var str:String = data?.getText().toString()
        //2. 문자열로 result에 셋팅
        result?.text = str
    }
}
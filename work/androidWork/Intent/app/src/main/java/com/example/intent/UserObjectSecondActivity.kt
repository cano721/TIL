package com.example.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_exam_second.*
import kotlinx.android.synthetic.main.activity_use_other_test.*

class UserObjectSecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exam_second)
        var objintent = intent
        var obj = objintent.getParcelableExtra<User>("myobj")
        textView.text = "이름:${obj?.myname}, 전화번호:${obj?.telNum}"
        button6.text = "끝~~~~"
        button6.setOnClickListener {
            finish()
        }
    }
}
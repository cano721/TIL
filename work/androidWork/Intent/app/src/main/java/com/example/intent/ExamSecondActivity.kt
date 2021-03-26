package com.example.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_exam_second.*
import kotlinx.android.synthetic.main.first2.*

class ExamSecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exam_second)
        var firstintent = intent
        val name = firstintent.getStringExtra("name")
        val number = firstintent.getStringExtra("number")
        textView.text = "입력한 이름:$name, 입력한 번호:$number"

        button6.setOnClickListener {
            //액티비티종료하기
            firstintent.putExtra("returndata",checkBox.isChecked)
            setResult(1111,firstintent)
            finish()
        }
    }
}
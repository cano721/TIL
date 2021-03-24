package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.firstexam.*

class ExamFirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.firstexam)
        Button01.setOnClickListener {
            val firstintent = Intent(this, ExamSecondActivity::class.java).apply {
                putExtra("name","${EditText01.text.toString()}")
                putExtra("number","${EditText02.text.toString()}")
            }
            startActivity(firstintent)
        }
        var listener = object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                first_return.setText("이름:${EditText01.text.toString()} 번호:${EditText02.text.toString()}")
            }
        }
        EditText01.addTextChangedListener(listener)
        EditText02.addTextChangedListener(listener)
    }
}
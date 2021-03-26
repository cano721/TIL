package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.firstexam.*

const val EXAM_BUTTON = 1111
class ExamFirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.firstexam)
        Button01.setOnClickListener {
            val firstintent = Intent(this, ExamSecondActivity::class.java).apply {
                putExtra("name",EditText01.text.toString())
                putExtra("number",EditText02.text.toString())
            }
            startActivityForResult(firstintent, EXAM_BUTTON)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode== EXAM_BUTTON){
            if(resultCode==1111){
                var state = data?.getBooleanExtra("returndata",false)
                first_return.text = ""
                if(state==true){
                    first_return.text = "${first_return.text} 우수회원설정"
                }else{
                    first_return.text = "${first_return.text} 일반회원설정"
                }
            }
        }
    }
}
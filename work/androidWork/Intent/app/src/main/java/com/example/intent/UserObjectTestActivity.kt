package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.firstexam.*

class UserObjectTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.firstexam)
        Button01.setOnClickListener {
            //인텐트를 생성
            var objIntent = Intent(this,UserObjectSecondActivity::class.java)
            var obj = User()
            obj.myname = EditText01.text.toString()
            obj.telNum = EditText02.text.toString()
            objIntent.putExtra("myobj",obj)
            startActivity(objIntent)
        }
    }
}
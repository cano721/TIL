package com.example.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.second2.*

class ReturnDataSecondActivity : AppCompatActivity() {
    var code:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second2)
        //첫 번째 액티비티에서 startActivityForResult하면서 전달한 인텐트를 받아오기
        val returnIntent = intent
        code = returnIntent.getStringExtra("code")
        btnClose1.setOnClickListener {
            when (code) {
                "call2" -> {
                    val data = returnIntent.getStringExtra("info")
                    secondTxt.text = data
//                    Toast.makeText(this@ReturnDataSecondActivity, data, Toast.LENGTH_LONG).show()
                    returnIntent.putExtra("returndata","가입작업완료")
                    //실행한 후에 호출한 액티비티로 되돌아가며 값을 공유하기 위해 인텐트객체를 넘기기
                    setResult(1,returnIntent)
                    finish()
                }
                "call3" -> {
                    val data = returnIntent.getStringExtra("info")
                    secondTxt.text = data
//                    Toast.makeText(this@ReturnDataSecondActivity, data, Toast.LENGTH_LONG).show()
                    returnIntent.putExtra("returndata","수정작업완료")
                    setResult(2,returnIntent)
                    finish()
                }
        }

        }
    }
}
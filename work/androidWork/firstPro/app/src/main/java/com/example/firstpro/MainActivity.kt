package com.example.firstpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.btn)
    }
    fun btnOk(view: View){
        Toast.makeText(this,"버튼Ok 클릭", Toast.LENGTH_LONG).show()
    }
    fun btnCancel(view:View){
        Toast.makeText(this,"버튼Cancel 클릭.",Toast.LENGTH_LONG).show()
    }
}
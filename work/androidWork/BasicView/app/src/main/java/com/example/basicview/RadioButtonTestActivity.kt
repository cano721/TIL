package com.example.basicview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_radio_button_test.*

class RadioButtonTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button_test)
        val listener =  MyRadioListener()
        group1.setOnCheckedChangeListener(listener)
        group2.setOnCheckedChangeListener(listener)
    }
    fun radioCheck(v: View){
        radioButton2.isChecked = true
        radioButton5.isChecked = true
    }
    fun getCheckStatus(v:View){
        //라디오그룹내에서 선택되어 있는 라디오버튼을 가져오기
        val id1 = group1.checkedRadioButtonId
        val id2 = group2.checkedRadioButtonId
        radioInfo.text = id1.toString()+"radio버튼이 선택됨"
        radioInfo2.text = id2.toString()+"radio버튼이 선택됨"
    }
    inner class MyRadioListener: RadioGroup.OnCheckedChangeListener{
        override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
            Log.d("radio",group?.id.toString()+"==============="+checkedId)
            when(group?.id){
                R.id.group1 -> {
                    //선택된 라디오버튼의 문자열을 텍스트뷰에 출력
                    val radio = findViewById<RadioButton>(group1.checkedRadioButtonId)
                    radioInfo.text = radio.text
                }
            }
            when(group?.id){
                R.id.group2 -> {
                    //선택된 라디오버튼의 문자열을 텍스트뷰에 출력
                    val radio2 = findViewById<RadioButton>(group2.checkedRadioButtonId)
                    radioInfo2.text = radio2.text
                }
            }
        }

    }
}
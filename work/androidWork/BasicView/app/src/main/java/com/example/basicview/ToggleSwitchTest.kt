package com.example.basicview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_toggle_switch_test.*

class ToggleSwitchTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toggle_switch_test)
        ts_button1.setOnClickListener {
            if(toggleButton.isChecked){
                ts_info.text = "ON State"
            }
            else{
                ts_info.text = "OFF State"
            }
        }

        ts_button2.setOnClickListener {
            toggleButton.isChecked = true
        }
        ts_button3.setOnClickListener {
            toggleButton.isChecked = false
        }
        ts_button4.setOnClickListener {
            toggleButton.toggle()
        }
        //Toggle버튼의 이벤트 처리
        toggleButton.setOnClickListener {
            ts_info.text = "토글버튼이 눌려짐(토글상태:${toggleButton.isChecked})"
        }

        switch_button1.setOnClickListener{
            if(switch2.isChecked){
                ts_info.text = "스위치On"
            }else{
                ts_info.text = "스위치Off"
            }
        }
        switch_button2.setOnClickListener{
            switch2.isChecked = true
        }
        switch_button3.setOnClickListener{
            switch2.isChecked = false
        }

        switchCompat01.setOnCheckedChangeListener { buttonView, ischecked ->
            val msg:String = if(ischecked){
                "switch버튼이 선택됨"
            }else{
                "switch버튼이 해제됨"
            }
            showToast(msg)
        }//end setOnCheckedChangeListener
    } //end onCreate
    fun showToast(msg:String){
        //this
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
    }
}
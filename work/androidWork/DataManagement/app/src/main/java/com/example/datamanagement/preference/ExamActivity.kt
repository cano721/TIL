package com.example.datamanagement.preference

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.datamanagement.R
import kotlinx.android.synthetic.main.setting.*

class ExamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setting)
        val mysetting = getSharedPreferences("Exam_setting", Context.MODE_PRIVATE)
        val edtior:SharedPreferences.Editor = mysetting.edit()

        val getServiceChildren = mysetting.getString("data1","")
        val getNick = mysetting.getString("data2","")
        val getAlarm = mysetting.getBoolean("data3",false)
        val getSiren = mysetting.getBoolean("data4",false)

        first_edit.setText(getServiceChildren)
        second_edit.setText(getNick)
        check1.isChecked = getAlarm
        check2.isChecked = getSiren

        save.setOnClickListener {
            val putServiceChildren = first_edit.text.toString()
            edtior.putString("data1",putServiceChildren)
            val putNick = second_edit.text.toString()
            edtior.putString("data2",putNick)
            val putAlarm = check1.isChecked
            edtior.putBoolean("data3",putAlarm)
            val putSiren = check2.isChecked
            edtior.putBoolean("data4",putSiren)
            edtior.commit()
        }

    }
}
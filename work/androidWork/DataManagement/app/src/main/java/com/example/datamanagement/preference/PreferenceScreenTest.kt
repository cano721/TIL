package com.example.datamanagement.preference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.datamanagement.R
import kotlinx.android.synthetic.main.preference_screen_test.*

//preferences Screen
// -> UI를 이용해서 Preference를 만들 수 있도록 제공
// PreferenceFragment를 이용해서 작업
// 저장기능이 모두 구현되어 있음
class PreferenceScreenTest : AppCompatActivity() {
    private val fragment1 = SettingFragment()
    private val fragment2 = ResultFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.preference_screen_test)
        setting.setOnClickListener {
            setFragment("first")
        }
        showResult.setOnClickListener {
            setFragment("second")
        }
    }
    fun setFragment(name: String?) {
        val fragmentManager = supportFragmentManager
        val transaction =   fragmentManager.beginTransaction()
        when (name) {
            "first" -> {
                transaction.replace(R.id.container, fragment1)
            }
            "second" ->{
                transaction.replace(R.id.container, fragment2)
            }
        }
        transaction.commit()
    }

}
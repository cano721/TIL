package com.example.datamanagement.preference

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceFragmentCompat

import com.example.datamanagement.R

//PreferenceFragmentCompat을 상속받아 사용
//기본으로 제공되는 라이브러리가 아니라 추가 해야 한다.
class SettingFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.myapp_setting)
    }

}
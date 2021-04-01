package com.example.datamanagement.preference

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.example.datamanagement.R
import kotlinx.android.synthetic.main.setting_result_fragment.*


class ResultFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.setting_result_fragment, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Preference를 가져오기
        val mypref = PreferenceManager.getDefaultSharedPreferences(context)
        val value1 = mypref.getString("data1","")
        val chkval = mypref.getBoolean("chkwifi",false)
        textView.text = "Vale:${value1} \n chkval:$chkval"
    }

}
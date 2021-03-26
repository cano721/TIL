package com.example.fragment.exam

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragment.R
import kotlinx.android.synthetic.main.activity_fragment_exam01.*

class ViewFragment3 : Fragment(){
    //fragment가 뷰를 만들때 호출되는 메소드
    //액티비티에 배치될때 호출된다. - 프래그먼트에 보여질 뷰를 그리기 위해서 호출하는 메소드
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.view3,container,false)
        return view
    }
}
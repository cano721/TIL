package com.example.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class SecondFragment :Fragment() {
    //fragment가 뷰를 만들때 호출되는 메소드
    //액티비티에 배치될때 호출된다. - 프래그먼트에 보여질 뷰를 그리기 위해서 호출하는 메소드
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("lifecycle","Fagement:::::::oncreateView()")
        val view = inflater.inflate(R.layout.fragment_second2,container,false)
        return view
    }
}

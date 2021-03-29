package com.example.fragment.tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragment.R
import kotlinx.android.synthetic.main.subfragment_view.*

//프레그먼트 한개로 여러 개의 프레그먼트 객체를 생성해서 사용
class SubMyFragment :Fragment{
    //lateinit은 모든 변수에서 가능한 것이 아니라 primitive(기본형)에서 사용
    //실행할때 초기화할 목적
    lateinit var title : String
    constructor(title:String){
        this.title = title
    }
    //뷰를 생성
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.subfragment_view,null)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subfragment_text.text = title
    }
}
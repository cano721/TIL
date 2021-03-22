package com.example.adapterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.list_view_test.*

class CustomRowTestActivity : AppCompatActivity() {
    //1. listview에 출력할 데이터 - 커스텀row로 리스트뷰를 구성하는 경우
    // -> 데이터는 arrayList로 구성
    var datalist = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_view_test)
        datalist.add("장동건")
        datalist.add("이민호")
        datalist.add("김어준")
        datalist.add("주진우")
        datalist.add("계해범")

        //2.Adapter객체를 생성
        val myadapter = ArrayAdapter(this,R.layout.custrow,R.id.txtcust1,datalist)
        //                                       ----------------  -------------
        //                              row의 디자인- 사용자정의 뷰  사용자정의 뷰에 포함된 textview
        listview1.adapter = myadapter
    }
}
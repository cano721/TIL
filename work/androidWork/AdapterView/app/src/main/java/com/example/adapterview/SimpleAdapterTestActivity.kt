package com.example.adapterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.list_view_test.*

class SimpleAdapterTestActivity : AppCompatActivity() {
    //두 줄 텍스트로 리스트뷰를 구성하기
    //1. 리스트뷰에 출력할 데이터
    var listdata = ArrayList<HashMap<String,String>>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_view_test)
        //리스트를 구성할 샘플 데이터를 준비
        //항목하나에 두 종류의 텍스트를 출력 - row에 보여줄 데이터를 HashMap에 저장
        var item = HashMap<String,String>()
        item["name"] = "김서연"
        item["telNum"] = "010-1111-7777"
        listdata.add(item)

        item = HashMap<String,String>()
        item["name"] = "홍길동"
        item["telNum"] = "010-2222-7777"
        listdata.add(item)

        item = HashMap<String,String>()
        item["name"] = "이민호"
        item["telNum"] = "010-3333-7777"
        listdata.add(item)

        item = HashMap<String,String>()
        item["name"] = "장동건"
        item["telNum"] = "010-5555-7777"
        listdata.add(item)

        //리스트뷰에 출력할 데이터가 한 개가 아니라 여러 개 이므로 어떤 뷰에 어떤 데이터를 연결해서 보여줄 지를 정확하게 명시
        val adapter = SimpleAdapter(this,
            listdata, //연결할 데이터
            android.R.layout.simple_list_item_2, // 한 row에 대한 디자인리소스
            arrayOf("name","telNum"), //HashMap의 Key 목록을 배열로 정의(어떤 데이터를 꺼낼건지)
            intArrayOf(android.R.id.text1,android.R.id.text2)) //바로 전에 정의한 key를 어떤 리소스에 연결할 것인지 리소스의 id값 명시
        listview1.adapter = adapter
    }
}
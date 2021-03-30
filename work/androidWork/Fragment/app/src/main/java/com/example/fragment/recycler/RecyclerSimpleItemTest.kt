package com.example.fragment.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragment.R
import kotlinx.android.synthetic.main.activity_recycler_simple_item_test.*

class RecyclerSimpleItemTest : AppCompatActivity() {
    var datalist = ArrayList<SimpleItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_simple_item_test)
        //1. RecyclerView에 출력할 데이터를 준비
        for(i in 0..9){
            val item = SimpleItem("simple_item$i")
            datalist.add(item)
        }

        //2. Adapter를 생성
        val myAdapter = SimpleItemAdapter(this,R.layout.simple_item,datalist)

        //3. RecyclerView의 레이아웃을 설정
        /*
            RecyclerView는 꼭 배치 방식을 설정해야 한다.
            - LinearLayout

            - GridLayout
         */
        //3-1. LinearLayout
//        val manager = LinearLayoutManager(this)
//        manager.orientation = LinearLayoutManager.HORIZONTAL
//        myrecycler1.layoutManager = manager
        //3-2. GridLayout
        val manager = GridLayoutManager(this,2)
        myrecycler1.layoutManager = manager


        //4, RecyclerView와 어댑터 연결
        myrecycler1.adapter = myAdapter
    }
}
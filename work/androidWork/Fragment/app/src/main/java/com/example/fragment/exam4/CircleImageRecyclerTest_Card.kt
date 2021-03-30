package com.example.fragment.exam4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragment.R
import com.example.fragment.recycler.SimpleItemAdapter
import kotlinx.android.synthetic.main.activity_circle_image_recycler_test.*
import kotlinx.android.synthetic.main.activity_recycler_simple_item_test.*

class CircleImageRecyclerTest_Card : AppCompatActivity() {
    var datalist = ArrayList<CircleItem_Card>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circle_image_recycler_test)
        datalist.add(CircleItem_Card(R.drawable.dog,"강아지는 귀엽다"))
        datalist.add(CircleItem_Card(R.drawable.gong,"공유"))
        datalist.add(CircleItem_Card(R.drawable.jang,"장쓰"))
        datalist.add(CircleItem_Card(R.drawable.jung,"정우성"))
        datalist.add(CircleItem_Card(R.drawable.lee,"리"))
        datalist.add(CircleItem_Card(R.drawable.so,"소"))


        //어댑터 연결
        val myAdapter = RecyclerCircleAdapter_Card(this,R.layout.circle_item_card,datalist)

        //레이아웃 설정
//        val manager = GridLayoutManager(this,2)
//        recycler_exam.layoutManager = manager

        val manager = LinearLayoutManager(this)
        manager.orientation = LinearLayoutManager.VERTICAL
        recycler_exam.layoutManager = manager

        //4, RecyclerView와 어댑터 연결
        recycler_exam.adapter = myAdapter
    }
}
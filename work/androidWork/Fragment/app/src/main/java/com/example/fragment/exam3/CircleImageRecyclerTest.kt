package com.example.fragment.exam3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragment.R
import com.example.fragment.recycler.SimpleItemAdapter
import kotlinx.android.synthetic.main.activity_circle_image_recycler_test.*
import kotlinx.android.synthetic.main.activity_recycler_simple_item_test.*

class CircleImageRecyclerTest : AppCompatActivity() {
    var datalist = ArrayList<CircleItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circle_image_recycler_test)
        datalist.add(CircleItem(R.drawable.dog))
        datalist.add(CircleItem(R.drawable.gong))
        datalist.add(CircleItem(R.drawable.jang))
        datalist.add(CircleItem(R.drawable.jung))
        datalist.add(CircleItem(R.drawable.lee))
        datalist.add(CircleItem(R.drawable.so))


        //어댑터 연결
        val myAdapter = RecyclerCircleAdapter(this,R.layout.circle_item,datalist)

        //레이아웃 설정
//        val manager = GridLayoutManager(this,2)
//        recycler_exam.layoutManager = manager

        val manager = LinearLayoutManager(this)
        manager.orientation = LinearLayoutManager.HORIZONTAL
        recycler_exam.layoutManager = manager

        //4, RecyclerView와 어댑터 연결
        recycler_exam.adapter = myAdapter
    }
}
package com.example.adapterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.list_view_test.*


class CustomRowTestActivity2 : AppCompatActivity() {
    var imageRes = intArrayOf(R.drawable.ansoccer,R.drawable.jjangkim,R.drawable.chasoccer,R.drawable.kbr)
    var data1 = arrayOf("이민호","장동건","김어준","주진우","김서연")
    var data2 = arrayOf("멋지다","아저씨","힘내라","이기자","화이팅")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_view_test)

        //simpleAdapter에 설정할 데이터를 정의
        var datalist = ArrayList<HashMap<String,Any>>()
        for(i in imageRes.indices){
            val map = HashMap<String,Any>()
            map["img"] = imageRes[i]
            map["data1"] = data1[i]
            map["data2"] = data2[i]
            datalist.add(map)
        }
        //key와 연결할 리소스id를 배열로 정의
        val keylist = arrayOf("img","data1","data2")
        val res_id_list = intArrayOf(R.id.myimg,R.id.txtcust1,R.id.txtcust2)

        //어댑터 생성
        val adapter = SimpleAdapter(this,datalist,R.layout.custrow,keylist,res_id_list)
        listview1.adapter = adapter

        listview1.setOnItemClickListener { parent, view, position, id ->
            Log.d("test","자바:"+parent.toString()+"=========="+view.toString())
            Log.d("test","코틀린:"+parent+"=========="+view)
            listText.text = "${data1[position]}과 ${data2[position]}을 선택함"
        }
        }
    }


// 내 풀이(실습)

//class CustomRowTestActivity2 : AppCompatActivity() {
//    var listdata = ArrayList<HashMap<String,Any>>()
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.list_view_test)
//
//        var item = HashMap<String,Any>()
//        item["name"] = "이민호"
//        item["image"] = R.drawable.kimdong
//        item["text"] = "멋져"
//        listdata.add(item)
//
//        item = HashMap<String,Any>()
//        item["name"] = "테리우스"
//        item["image"] = R.drawable.ansoccer
//        item["text"] = "간지"
//        listdata.add(item)
//
//        item = HashMap<String,Any>()
//        item["name"] = "차붐"
//        item["image"] = R.drawable.chasoccer
//        item["text"] = "차붐!!"
//        listdata.add(item)
//
//        item = HashMap<String,Any>()
//        item["name"] = "어준쓰"
//        item["image"] = R.drawable.kbr
//        item["text"] = "으"
//        listdata.add(item)
//
//        item = HashMap<String,Any>()
//        item["name"] = "장김"
//        item["image"] = R.drawable.jjangkim
//        item["text"] = "모르겟다"
//        listdata.add(item)
//
//        val adapter = SimpleAdapter(
//            this,
//            listdata,
//            R.layout.custrow,
//            arrayOf("name","image","text"),
//            intArrayOf(R.id.txtcust1,R.id.myimg,R.id.txtcust2)
//        )
//        listview1.adapter = adapter
//    }
//}
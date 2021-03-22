package com.example.adapterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.list_view_test.*

class ResourceDataListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_view_test)
        //1. listview에 출력할 데이터
        //2. adapter생성 - 리소스를 이용해서 어뎁터를 생성
        val myadapter = ArrayAdapter.createFromResource(this,R.array.mylist_data,android.R.layout.simple_list_item_1)
        //3. 리스트뷰에 어댑터연결
        listview1.adapter = myadapter
        //4. 이벤트연결
        listview1.onItemClickListener = mylistener
    }
    var mylistener = object :AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            //매개변수 view -> 목록에 포함된 하나의 row를 구성
//            val selectview:TextView = view as TextView -> view를 TextView타입으로 변경하라는 의미(타입캐스팅)
//            listText.text = "선택한 항목:${selectview.text}"
            Log.d("list",parent.toString()+"...."+view.toString()+"...."+ position + ",,,,"+id)
            listText.text = "선택한 항목:${(view as TextView).text}"
        }

    }
}
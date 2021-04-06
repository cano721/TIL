package com.example.examproject

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examproject.sqlite.DBHelper
import com.example.fragment.recycler.SimpleItem
import com.example.fragment.recycler.SimpleItemAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), View.OnClickListener{
    var datalist = ArrayList<SimpleItem>()
    val sdf = SimpleDateFormat("yyyy-MM-dd",Locale.getDefault())
    val nowdate = sdf.format(Date())

    lateinit var  mqttClient:MyMqtt
    var mydb:SQLiteDatabase ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 통신 연결부
        mqttClient = MyMqtt(this,"tcp://172.30.1.52:1883")
        try{
            mqttClient.connect(arrayOf<String>("iot/#"))
        }catch (e: Exception){
            e.printStackTrace()
        }
        btn_led_on.setOnClickListener(this)
        btn_led_off.setOnClickListener(this)

        //데이터 저장 부
        var helper = DBHelper(this)
        mydb = helper.writableDatabase


        //데이터 연결 및 뷰
       val myAdapter = SimpleItemAdapter(this,R.layout.simple_item,datalist)

        val manager = LinearLayoutManager(this)
        manager.orientation = LinearLayoutManager.VERTICAL
        recycler1.layoutManager = manager
        recycler1.adapter = myAdapter
    }

    override fun onClick(v: View?) {
        var data:String = ""
        if(v?.id==R.id.btn_led_on){
            data = "led_on"
        }else{
            data = "led_off"
        }
        val sql = """
                insert into job(date,id,ledstate) values(?,?,?)
            """.trimIndent()
        mydb?.execSQL(sql, arrayOf(
            nowdate.toString(),"cano",data
        ))
        //데이터 조회 추가
        var sql2 = "select * from job"
        val cursor: Cursor = mydb!!.rawQuery(sql2,null)
        while(cursor.moveToNext()){ //테이블내부에서 커서를 다음 레코드로 이동(레코드가 존재하면true, 없으면 false를 리턴)
            val idx = cursor.getInt(0)
            val date = cursor.getString(1)
            val id = cursor.getString(2)
            val ledstate = cursor.getString(3)
            val item = SimpleItem(date,id,ledstate)
            datalist.add(item)
        }
        publish(data)
    }

    fun publish(data:String){
        //mqttClient의 publish기능의 메소드를 호출
        mqttClient.publish("mydata/led",data)
    }

}
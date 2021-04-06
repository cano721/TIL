package com.example.iot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var  mqttClient:MyMqtt
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mqttClient = MyMqtt(this,"tcp://172.30.1.52:1883")
        try {
            mqttClient.connect(arrayOf<String>("iot/#"))
        }catch (e:Exception){
            e.printStackTrace()
        }
        btn_led_on.setOnClickListener(this)
        btn_led_off.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        var data:String = ""
        if(v?.id==R.id.btn_led_on){
            data = "led_on"
        }else{
            data = "led_off"
        }
        publish(data)
       }
    fun publish(data:String){
        //mqttClient의 publish기능의 메소드를 호출
        mqttClient.publish("mydata/led",data)
    }
}
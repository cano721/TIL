package com.example.iot.mqtt

import android.content.Context
import android.util.Log
import org.eclipse.paho.android.service.MqttAndroidClient
import org.eclipse.paho.client.mqttv3.*

class MyMqtt(val context: Context, val uri:String) {
    var mqttClient:MqttAndroidClient = MqttAndroidClient(context,uri,MqttClient.generateClientId())
    //등록한 토픽에 맞는 메시지가 도착하면 사용자정의 메소드를 실행할 수 있도록 callback구현 --3
    fun setCallback(callback :(topic:String,message:MqttMessage)->Unit){
        mqttClient.setCallback(object :MqttCallback{

            override fun messageArrived(topic: String?, message: MqttMessage?) {
                Log.d("mymqtt","message Arrived")
                //서버가 메시지를 보내주면 callback메소드로 등록한 onReceived메소드를 호출하며 서버로부터 전달받은
                //토픽정보와 메시지를 전달해준다.
                callback(topic!!,message!!)
            }

            override fun connectionLost(cause: Throwable?) {
                Log.d("mymqtt","connectionLost")
            }

            override fun deliveryComplete(token: IMqttDeliveryToken?) {
                Log.d("mymqtt","deliveryComplete")
            }
        })
    }
    fun connect(topics : Array<String>?=null){
        val mqttconnect_options = MqttConnectOptions()
        //connect호출 - broker에 연결
        mqttClient.connect(mqttconnect_options,null,object :IMqttActionListener{
            override fun onSuccess(asyncActionToken: IMqttToken?) {
                Log.d("mymqtt","connect suceed")
                //서버(mqtt broker)로 접속이 성공하면 토픽을 전송 --2
                topics?.map { subscribeTopic(it)}
            }

            override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                Log.d("mymqtt","connect failed")
            }

        })
    }
    //토픽 subscribe등록 - 토픽을 서버에 등록하기 위한 메소드 --- 1
    private fun subscribeTopic(topic: String,qos: Int= 0){
        mqttClient.subscribe(topic, qos,null,object :IMqttActionListener{
            override fun onSuccess(asyncActionToken: IMqttToken?) {
                Log.d("mymqtt","subscribe sucess")
            }

            override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                Log.d("mymqtt","subscribe fail")
            }

        })
    }
    //broker에 publish할때 사용할 메소드
    fun publish(topic:String, payload:String,qos:Int=0){
        if(mqttClient.isConnected() === false){
            mqttClient.connect()
        }
        val message = MqttMessage()
        message.payload = payload.toByteArray() //String을 byte배열로 변환 - 네트워크로 전송
        message.qos = qos
        mqttClient.publish(topic, message,null,object :IMqttActionListener{
            override fun onSuccess(asyncActionToken: IMqttToken?) {
                Log.d("mymqtt","publish 성공")
            }

            override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                Log.d("mymqtt","publish 실패")
            }

        })
    }
}
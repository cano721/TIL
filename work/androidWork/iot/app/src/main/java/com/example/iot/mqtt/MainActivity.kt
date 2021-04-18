package com.example.iot.mqtt

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.app.NotificationCompat
import com.example.iot.R
import com.example.iot.sensor.DetectionActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_noti.*
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.eclipse.paho.client.mqttv3.MqttTopic
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var mqttClient: MyMqtt
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mqttClient = MyMqtt(this, "tcp://172.30.1.52:1883")
        try {
            mqttClient.setCallback(::onReceived)
            mqttClient.connect(arrayOf<String>("iot/#"))
        } catch (e: Exception) {
            e.printStackTrace()
        }
        btn_led_on.setOnClickListener(this)
        btn_led_off.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var data: String = ""
        if (v?.id == R.id.btn_led_on) {
            data = "led_on"
        } else {
            data = "led_off"
        }
        publish(data)
    }

    fun publish(data: String) {
        //mqttClient의 publish기능의 메소드를 호출
        mqttClient.publish("mydata/led", data)
    }

    fun onReceived(topic: String, message: MqttMessage) {
        //토픽수신처리
        val msg = String(message.payload)
        if (msg.equals("motion detect")) {
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.lee)
                val builder = NotificationCompat.Builder(this, "1111")
                    .setSmallIcon(android.R.drawable.ic_notification_overlay)
                    .setContentTitle("연습")
                    .setContentText("노티피케이션연습")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setLargeIcon(bitmap)
                    .setDefaults(
                        Notification.DEFAULT_SOUND or Notification.DEFAULT_VIBRATE or
                                Notification.DEFAULT_LIGHTS
                    )
                val style = NotificationCompat.BigPictureStyle(builder)
                style.bigPicture(bitmap)
                builder.setStyle(style)
                val myIntent = Intent(this, DetectionActivity::class.java)
                val mypendingIntent = PendingIntent.getActivity(
                    this, 10, myIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT
                )
                builder.setContentIntent(mypendingIntent)
                createNotiChannel(builder, "2222")
                showdata.append("침입자 발생!! ------------${Date().toString()}\n")
            }
            Log.d("mymqtt", msg)
    }

    fun createNotiChannel(builder: NotificationCompat.Builder, id: String) {
        //낮은 버전의 사용자에 대한 설정
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel(id, "mynetworkchannel", NotificationManager.IMPORTANCE_HIGH)
            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
            notificationManager.notify(Integer.parseInt(id), builder.build())
        } else {
            //이전 버전인 경우
            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(Integer.parseInt(id), builder.build())
        }
    }
}
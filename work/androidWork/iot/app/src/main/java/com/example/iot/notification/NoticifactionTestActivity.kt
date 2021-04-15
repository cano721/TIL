package com.example.iot.notification

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
import androidx.core.app.NotificationCompat
import com.example.iot.R
import com.example.iot.mqtt.MainActivity
import kotlinx.android.synthetic.main.activity_noti.*

class NoticifactionTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noti)
        val bitmap = BitmapFactory.decodeResource(resources,R.drawable.lee)
        basic_noti.setOnClickListener {
            val builder = NotificationCompat.Builder(this,"1111")
                    .setSmallIcon(android.R.drawable.ic_notification_overlay)
                    .setContentTitle("연습")
                    .setContentText("노티피케이션연습")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setLargeIcon(bitmap)
                    .setDefaults(Notification.DEFAULT_SOUND or Notification.DEFAULT_VIBRATE or
                    Notification.DEFAULT_LIGHTS)
            val style = NotificationCompat.BigPictureStyle(builder)
            style.bigPicture(bitmap)
            builder.setStyle(style)
            /*
                Notification이 발생되고 노티를 클릭하면 사용자의 이벤트를 받아서 처리
                => 앱의 특정 액티비티를 실행(인텐트)
                알림이 실행되는 곳이 액티비티가 아니라 시스템이 제어한다.
                우리가 직접 이벤트에 따라 액티비티가 실행되도록 제어할 수 없다. 인텐트를 통해서 액티비티가 실행되도록
                해야 하는데 우리가 직접 인텐트를 실행할 수 없기 때문에 인텐트의 실행을 시스템에 의뢰해야 한다.
                이때 사용되는 객체가 PendingIntent다. 이 PendingIntent는 Notification에서만 사용되지 않고 인텐트의
                실행을 시스템에 의뢰해야하는 모든 작업에서 사용된다.

                1. 실행할 액티비티를 이용해서 인텐트를 생성
                2. PendingIntent에 의뢰
             */
            /*
                FLAG_CANCLE_CURRENT: 이전에 생성한 PendingIntent가 있으면 취소하고 다시 만들기
                FLAG_UPDATE_CURRENT: 현재의 내용으로 이전 객체 업데이트
                FLAG_NO_CREATE: PendingIntent를 새롭게 만들지 않고 이미 만들어진 PendingIntent를 그대로 사용하기
                FLAG_ONE_SHOT: 한 번만 PendingIntent를 만들기 위해 사용
             */
            val myIntent = Intent(this,MainActivity::class.java)
            val mypendingIntent = PendingIntent.getActivity(this,10,myIntent,
                            PendingIntent.FLAG_UPDATE_CURRENT)
            builder.setContentIntent(mypendingIntent)
            createNotiChannel(builder,"1111")

        }
    }
    /*
        notification객체를 이용해야하며 직접 생성하지 않고 NotificationCompat.Builder를 이용해서 생성
        안드로이드 sdk버전8부터 Notification을 사용하기 위해선 Notification channel을 이용해서 알림메시지에 대한 관리를 해야한다.
        알림의 종류에 따라 직접 다르게 할 수 있다.
        - 네트워크에 관련된 알림인지, 저장에 관련된 알림인지 ... 상세정의가 가능
     */
    fun createNotiChannel(builder:NotificationCompat.Builder,id:String){
        //낮은 버전의 사용자에 대한 설정
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            val channel =
                NotificationChannel(id,"mynetworkchannel",NotificationManager.IMPORTANCE_HIGH)
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
            notificationManager.notify(Integer.parseInt(id),builder.build())
          }else{
            //이전 버전인 경우
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(Integer.parseInt(id),builder.build())
        }
    }
}
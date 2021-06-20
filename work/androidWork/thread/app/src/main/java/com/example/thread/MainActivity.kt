package com.example.thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlin.concurrent.thread

//스레드는 프로세스를 동작하는 여러 실행의 흐름(운영체제로부터 자원을 할당받은 작업의 단위)
//최소 1개의 스레드를 가지고 있고 이걸 메인 스레드라고 함
//두개 이상의 스레드를 가지고 있느 프로세스를 멀티스레드 프로세스라고 부름

//안드로이드 메인 스레드는
// * 화면의 UI처리 담당
// * UI와 상호작용하고 사용자에게 보여줌
// * UI이벤트 등 일정시간동안 응답이 없으면 ANR팝업 표시(ANR: 응용 프로그램이 응답하지 않음)

//그렇기 때문에 별도 백그라운드 스레드를 통해 오래걸리는 작업을 처리함


//기본적인 스레드
class ThreadTest: Thread(){
    override fun run() {
        var i = 0

        while (i<10){
            i += 1
            Log.i("ThreadTest", "i = $i")
        }
    }
}

//Runnable Thread
//Thread()를 상속받으면 다른 클래스를 상속받을 수 없으나,
//Runnable를 상속받은 Thread는 다른 클래스도 구현할 수 있음.(일반적으로 사용하는 스레드)
class RunnableTest : Runnable{
    override fun run() {
        var i = 10

        while(i<20){
            i +=1
            Log.i("RunnableTest", "i = $i")
        }
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //외부선언 스레드
        var a = ThreadTest()
        a.run()

        var b = RunnableTest()
        b.run()
        //코틀린 안에서의 스레드
        thread(start = true){
            var i = 20
            while (i<30){
                i += 1
                Log.d("main", "i = $i")
            }
        }
        thread(start = true){
            var i = 30
            while (i<40){
                i += 1
                Log.d("main2", "i = $i")
            }
        }
        //ui접근 가능한 스레드
        val textView = findViewById<TextView>(R.id.textView)
        thread(start = true){
            var i = 30
            while (i<40){
                i += 1
                runOnUiThread {
                    textView.text = "카운트 i=$i"
                }
                Thread.sleep(1000)
                Log.d("main3", "i = $i")
            }
        }
    }
}
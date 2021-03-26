package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //1. 사용할 프레그먼트객체를 생성
    val firstFragment = FirstFragment()
    val secondFragment = SecondFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_first.setOnClickListener {
            setFragment("first")
        }
        btn_second.setOnClickListener {
            setFragment("second")
        }
        btn_del.setOnClickListener {
            setFragment("remove")
        }
    }
    //미리 설정한 영역에 fragment를 교체해서 보여주기 위한 메소드
    fun setFragment(name:String){
        //2. Fragment객체를 관리하는 관리자 객체를 구한다.
        var fragmentManager = supportFragmentManager

        //3. Fragment객체 시작하기 - FragmentTransaction
        val transaction = fragmentManager.beginTransaction()
        when(name){
            "first" -> {
                //4. fragment처리를 위한 메소드
                //1. add
                //  매개변수1 - 상위 즉,Fragment를 연결할 container역할을 하는 뷰의 id
                //  매개변수2 - 연결할 Fragment
                // 동일한 객체는 한 개만 생성할 수 있다.
                //2. replace
                // -> 교체
                // -> 있으면 있는 객체로 연결, 없으면 새로 생성해서 연결
//                transaction.add(R.id.container,firstFragment)
                transaction.replace(R.id.container,firstFragment)
                transaction.addToBackStack("first")
            }
            "second" -> {
//                transaction.add(R.id.container,secondFragment)
                transaction.replace(R.id.container,secondFragment)
                transaction.addToBackStack("second")
            }
            "remove" -> transaction.remove(firstFragment)
        }
        //4. 병경한 작업을 실행해달라고 의뢰
        //commit은 스케쥴을 고려해서 적절한 시기에 변경해달라고 요청
        //commitNow() -> 당장 처리해달라고 요청
        transaction.commit()
    }
}
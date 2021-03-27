package com.example.fragment.exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.fragment.R
import kotlinx.android.synthetic.main.activity_fragment_exam01.*

class FragmentExam01 : AppCompatActivity() {
    val viewFragment1 = ViewFragment1()
    val viewFragment2 = ViewFragment2()
    val viewFragment3 = ViewFragment3()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_exam01)
    }
    fun btn_click(view: View){
        setFragment(view.getTag().toString())
    }

    fun setFragment(tag:String){
        //2. Fragment객체를 관리하는 관리자 객체를 구한다.
        var fragmentManager = supportFragmentManager

        //3. Fragment객체 시작하기 - FragmentTransaction
        val transaction = fragmentManager.beginTransaction()
        when(tag){
            "0" -> {

                transaction.replace(R.id.view_container,viewFragment1)
                transaction.addToBackStack("0")
            }
            "1" -> {
                transaction.replace(R.id.view_container,viewFragment2)
                transaction.addToBackStack("1")
            }
            "2" -> {
                transaction.replace(R.id.view_container,viewFragment3)
                transaction.addToBackStack("2")
            }
        }
        //4. 병경한 작업을 실행해달라고 의뢰
        //commit은 스케쥴을 고려해서 적절한 시기에 변경해달라고 요청
        //commitNow() -> 당장 처리해달라고 요청
        transaction.commit()
    }
}
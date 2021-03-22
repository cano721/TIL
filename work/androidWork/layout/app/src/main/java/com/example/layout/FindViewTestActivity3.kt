package com.example.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_find_view_exam2.*

//레이아웃파일에서 뷰를 찾아서 코드를 연결 - 1번방법
//동일한 이벤트를 발생시키는 위젯이 많은 경우 어떤 방법으로 처리해야 하는지?
class FindViewTestActivity3 : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_view_exam2)
       //이벤트연결
        btnDream1.setOnClickListener(this)
        btnDream2.setOnClickListener(this)
        btnBeach.setOnClickListener(this)
        ic_lb.setOnClickListener(this)
    }
    //이벤트처리 - 매개변수소 View타입의 변수를 정의하고 있다.
    //                      --------------------
    //                      클릭이벤트를 발생시키는 위젯의 종류가 많고 이벤트가 발생하는 시점에 어떤 위젯이
    //                      이벤트를 발생시키는지 알아야 하므로 부모인 View를 둠
    override fun onClick(v: View?) {
        //식별자를 이용해서 작업
        when(v?.id){
            R.id.btnDream1 ->{
                mainImg.setImageResource(R.drawable.dream01)
            }
            R.id.btnDream2 ->{
                mainImg.setImageResource(R.drawable.dream02)
            }
            R.id.btnBeach ->{
                mainImg.setImageResource(R.drawable.beach)
            }
            R.id.ic_lb ->{
                mainImg.setImageResource(R.drawable.ic_launcher_background)
            }

        }
    }
}
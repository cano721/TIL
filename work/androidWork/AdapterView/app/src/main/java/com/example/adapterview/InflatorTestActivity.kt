package com.example.adapterview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.activity_inflator_test.*

//레이아웃을 그려주는 시스템서비스 기능을 이용해서 직접 xml로 만들어진 뷰를 생성해보기
//                   ---------------
//                   LayoutInflator
class InflatorTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inflator_test)
        var include_container = container

        //버튼이 눌려지면 include_view.xml을 화면으로 만들어서 include_container에 붙이기
        //xml을 이용해서 화면에 붙일 수 있는 뷰를 생성해주는 객체를 안드로이드os로 부터 가져와서 작업업
       btnAdd.setOnClickListener {
           val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
           /*
           inflate( 1. 객체화하고싶은(화면으로 만들고 싶은) xml파일
                    2. 객체로 만든 뷰를 추가할 부모 레이아웃
                    3. true(바로 화면에 만들어서 추가하고자 하는지 유무)
                    ---------
                    attachRoot가 true일 경우 생성되는 뷰를 2번에서 부모로 지정한 뷰에 child로 추가
                    false일 경우 생성되는 뷰의 LayoutParams를 만들기 위해 참고하는 뷰로 활용
            */

           inflater.inflate(R.layout.include_view,include_container,true)
        }

    }
}
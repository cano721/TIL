package com.example.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

//액티비티에 있는 뷰에 코드를 연결 - 액티비티이면서 이벤트에 반응할 수 있도록
//버튼이 눌려졌을 때 처리 작업 수행
//1. xml문서 내부에 정의되어 객체로 생성된 버튼을 찾아와야 한다.
//2. 버튼이 눌려졌을 때 처리할 기능들을 클래스로 정의
//3. 버튼과 2번에서 정의한 기능을 연결
class FindViewTestActivity : AppCompatActivity(), View.OnClickListener {
    var btn:Button?=null
    var result:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
         화면에 xml을 파싱해서 만들어 놓은 모든 위젯을 초기화해서 액티비티에 배치

         */
        setContentView(R.layout.activity_find_view_test)
        //1. 직접 찾아와서 사용하기 ========================
        //   반드시 setContentView다음에 찾아야 한다.
        //   멤버변수 btn과 result를 xml에 정의되어있는 Button과 TextView와 연결
        //btn = findViewById("xml에 등록된 아이디명") -> 리소스로 관리가 된다. R파일
        //R이라는 클래스는 프로젝트 안에 추가된 리소스를 관리하는 파일 - 이미지파일, 애니메이션,배열,문자열,id.. 등
        btn = findViewById(R.id.btnClick)
        //this 객체가 버튼을 클릭할때 실행될 메소드를 가지고 있는 클래스인 onClickListener 구현한 클래스이다.
        btn?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        //버튼을 누르면 xml에 정의된 위젯들의 설정을 변경
        btn?.setText(Date().toString()) // 버튼의 문자열을 오늘의 날짜 정보로 변경
        var myval = btn?.text
        Toast.makeText(this,"android...start..."+myval,Toast.LENGTH_LONG).show()
       // Log.d("layout","android start...")
    }

}
package com.example.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_frame_exam01.*

class FrameExam01 : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_exam01)
        //아래 셋온클릭과정을 xml 버튼에 onclick 설정을 미리해두면 안해도 된다.
        //android:onClick="myclick" 이렇게주고 함수명을 onclick오버라이딩이 아닌 myclick으로 주면 된다.
        loginPageBtn.setOnClickListener(this)
        RgPageBtn.setOnClickListener(this)
        infoPageBtn.setOnClickListener(this)
        RgBtn.setOnClickListener{
            var id:String = rgId?.getText().toString()
            var pwd:String = rgPwd?.getText().toString()
            var name:String = rgName?.getText().toString()
            textRg?.text = id + "\n"+ pwd + "\n"+name
        }

    }
    //FrameLayout안에서 필요한 view를 선택해서 볼 수 있도록
    //visibility 속성의 값은 invisible과 gone은 보이지 않도록 설정
    //invisible은 보이지 않지만 영역을 차지하고 있다. gone은 해제
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.loginPageBtn -> {
                loginLayout?.visibility = View.VISIBLE
                rgLayout?.visibility = View.INVISIBLE
                infoLayout?.visibility = View.INVISIBLE
            }
            R.id.RgPageBtn -> {
                loginLayout?.visibility = View.INVISIBLE
                rgLayout?.visibility = View.VISIBLE
                infoLayout?.visibility = View.INVISIBLE
            }
            R.id.infoPageBtn -> {
                loginLayout?.visibility = View.INVISIBLE
                rgLayout?.visibility = View.INVISIBLE
                infoLayout?.visibility = View.VISIBLE
            }
        }
    }
}
package com.example.basicview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.text_test.*

//기본뷰에 대한 테스트 -텍스트와 관련된 뷰의 기능들, 이벤트 처리 -TextView,EditText,Button
class TextTestActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.text_test)

        //EditTEXT에서 데이터를 입력할때 이벤트가 발생 -처리
        //TextChanged이벤트 발생 - TextWatcher라는 리스너를 구현

        //EditText에 TextWatcher리스너를 연결해야 이벤트에 대한 처리를 할 수 있따.
        var mylistner = MyWatcherListener()
        mytext.addTextChangedListener(mylistner)
        send.setOnClickListener(this)
    }
    //send버튼을 누르면 EditText(input)에 입력한 값이 area1,area2로 정의한 EditText출력
    override fun onClick(v: View?) {
        area1.append(input.text.toString() + "\n")
        area2.append(input.text.toString() + "\n")
        // area2.text = input.text 누적을 못함(히스토리를 못남김)

    }
//TextChanged이벤트를 처리하는 리스너를 작성 (TextWatcher)
      internal inner class MyWatcherListener : TextWatcher{
        //문자값이 변경된 후에 호출
        override fun afterTextChanged(s: Editable?) {

        }
        //문자가 변경되기 전에 호출
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }
        //문자의 값이 변경되고 있을때 호출출
       override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            Log.d("event","s:$s, start:$start, before:$before, count:$count")
            myinfo?.text = "문자열이 변경되고 있음...$s"
        }

    }

}
package com.example.basicview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_check_box_test.*
import kotlinx.android.synthetic.main.activity_toggle_switch_test.*

class CheckBoxTest : AppCompatActivity() {
    var checkBtnArr:Array<Button> = arrayOf()
    var checkBoxArr:Array<CheckBox> = arrayOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_box_test)
        checkBtnArr = arrayOf(check_button1, check_button2, check_button3, check_button4)
        checkBoxArr = arrayOf(checkBox1, checkBox2, checkBox3,checkBox4,checkBox5)
        // checkArr.indices도 있는데 이건 요소의 갯수가 반환됨
        var listener1 = CheckBoxTestListener()
        switch3.setOnCheckedChangeListener(listener1)
        for (i in checkBtnArr) {
            i.setOnClickListener(listener1)
        }
        for (i in checkBoxArr) {
            i.setOnCheckedChangeListener(listener1)
        }
    }
    internal inner class CheckBoxTestListener : CompoundButton.OnCheckedChangeListener, View.OnClickListener {
        //체크박스의 상태를 TextView에 출력
        fun getCheckStatus() {
            checkInfo.setText("")
            //var tag = checkBoxArr[i]?.tag.toString() 체크박스에 태그를 설정해놨으면 가져올 수 잇음
            var cnt = 1
            for (i in checkBoxArr) {
                if (i?.isChecked) {
                    checkInfo.append("checkBox${cnt}번 체크박스가 설정\n")
                }
                cnt+=1
            }
        }

        fun setCheck() {
            for (i in checkBoxArr) {
                i?.isChecked = true //isChecked에 대한 setter작업
            }
        }

        fun clearcheck() {
            for (i in checkBoxArr) {
                i?.isChecked = false //isChecked에 대한 setter작업
            }
        }

        fun checkToggle() {
            for (i in checkBoxArr) {
                i?.toggle() //isChecked에 대한 setter작업
            }
        }


        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
            Log.d("checkbox_test", "태그:" + buttonView?.getTag().toString() + "객체의값:" + buttonView.toString() +
                    "선택유무:" + isChecked)
            if(buttonView is CheckBox){
                if(isChecked){
                    checkInfo.text = "${buttonView.getTag().toString()}번째 체크박스가 선택"
                }else{
                    checkInfo.text = "${buttonView.getTag().toString()}번째 체크박스가 해제"
                }
            }else{
                if(buttonView?.id == R.id.switch3){
                    var msg = ""
                    msg = if(buttonView.isChecked){
                        "활성"
                    }else{
                        "비활성"
                    }
                    Toast.makeText(this@CheckBoxTest,msg,Toast.LENGTH_LONG).show()
                }
            }
        }

        override fun onClick(v: View?) {
            when (v?.id) {
                R.id.check_button1 -> setCheck()
                R.id.check_button2 -> getCheckStatus()
                R.id.check_button3 -> clearcheck()
                R.id.check_button4 -> checkToggle()
            }
        }
    }
}
// checkBox 사용
// checkBox의 주요 속성
// text, checked
// isChecked -> 현재 체크박스의 상태값을 true(체크박스가 선택되어 있는 상태) | false(체크박스의 선택이 해제된 상태)로 리턴
//class CheckBoxTest : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_check_box_test)
//        var listener1 = CheckBoxTestListener()
//        check_button1.setOnClickListener(listener1)
//        check_button2.setOnClickListener(listener1)
//        check_button3.setOnClickListener(listener1)
//        check_button4.setOnClickListener(listener1)
//
//        checkBox1.setOnCheckedChangeListener(listener1)
//        checkBox2.setOnCheckedChangeListener(listener1)
//        checkBox3.setOnCheckedChangeListener(listener1)
//    }
//    //CheckBoxTest액티비티를 구성하는 위젯에서 발생하는 모든 이벤트를 처리하는 리스너
//    //==> inner클래스로 작성하나 별도의 파일로 클래스를 구성해서 작성하기도 한다.
//    internal inner class CheckBoxTestListener:CompoundButton.OnCheckedChangeListener, View.OnClickListener{
//        //체크박스의 상태를 TextView에 출력
//        fun getCheckStatus(){
//            checkInfo.setText("")
//            if(checkBox1.isChecked){ //isChecked에 대한 getter 작업
//                checkInfo.append("checkBox1번 체크박스가 설정\n")
//            }
//            if(checkBox2.isChecked){
//                checkInfo.append("checkBox2번 체크박스가 설정\n")
//            }
//            if(checkBox3.isChecked){
//                checkInfo.append("checkBox3번 체크박스가 설정\n")
//            }
//        }
//        fun setCheck(){
//            checkBox1.isChecked = true //isChecked에 대한 setter작업
//            checkBox2.isChecked = true
//            checkBox3.isChecked = true
//        }
//        fun clearcheck(){
//            checkBox1.isChecked = false //isChecked에 대한 setter작업
//            checkBox2.isChecked = false
//            checkBox3.isChecked = false
//        }
//        fun checkToggle(){
//            checkBox1.toggle()
//            checkBox2.toggle()
//            checkBox3.toggle()
//        }
//        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
//            Log.d("checkbox_test","태그:"+buttonView?.getTag().toString() +"객체의값:"+buttonView.toString()+
//                    "선택유무:"+isChecked)
//        }
//        override fun onClick(v: View?) {
//            when(v?.id){
//                R.id.check_button1 -> setCheck()
//                R.id.check_button2 -> getCheckStatus()
//                R.id.check_button3 -> clearcheck()
//                R.id.check_button4 -> checkToggle()
//
//            }
//        }
//    }
//}

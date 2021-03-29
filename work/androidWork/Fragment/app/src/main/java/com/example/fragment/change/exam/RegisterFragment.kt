package com.example.fragment.change.exam

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.fragment.R
import com.example.fragment.exam2.FragmentExam02
import kotlinx.android.synthetic.main.activity_fragment_exam03.*
import kotlinx.android.synthetic.main.register.*

class RegisterFragment : Fragment() {
    var data:String ?= null
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.register, container, false)
//        val name_edit = view.findViewById<EditText>(R.id.edit_name)
//        val id_edit = view.findViewById<EditText>(R.id.edit_id)
//        val pass_edit = view.findViewById<EditText>(R.id.edit_pass)
//        val btn = view.findViewById<Button>(R.id.btn_insert)
//        btn.setOnClickListener {
//            Log.d("fragment","아이디${id_edit.text},성명:${name_edit.text},패스워드:${pass_edit.text}")
//        }
        //onCreateView메소드에서는 xml에 선언된 변수들은 만들어져 있는 상태지만 xml변수들에 각 객체가 할당되어 있지 않은 상태이므로
        // 엑세스하면 NullPointerException이 발생

//        btn_insert.setOnClickListener {
//            Log.d("fragment","성명:${edit_name.text}")
//        }
        return view
    }

    //view가 메모리에 할당된 후 호출되는 메소드인 onViewCreated메소드에서 xml에 정의된 id명으로 접근이 가능
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_insert.setOnClickListener {
            Log.d("fragment","아이디${edit_id.text},성명:${edit_name.text},패스워드:${edit_pass.text}")
            //부모액티비티인 FragmentExam02
            // --------------------
            // fragment가 연결되어있는 액티비티
            data = "아이디${edit_id.text},성명:${edit_name.text},패스워드:${edit_pass.text}"
            //fragment에서 가입버튼을 누르면 fragment에 연결되어 있는 액티비티의 EditText에 데이터 출력
            val parent = activity as FragmentExam03
            parent.maindata.setText(data)
        }
    }
    fun senddata():String{
        data = "아이디${edit_id.text},성명:${edit_name.text},패스워드:${edit_pass.text}"
        return data!!
    }
}
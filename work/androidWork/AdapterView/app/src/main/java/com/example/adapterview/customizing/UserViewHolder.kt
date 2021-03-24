package com.example.adapterview.customizing

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.adapterview.R

//뷰를 재사용하기위해 정의
class UserViewHolder {
    var myImg:ImageView? = null
    var nameView:TextView? = null
    var telNumView:TextView? = null
    var EditView:EditText? = null

    //UserViewHolder객체가 생성될때 targetView를 전달받는다.
    constructor(parentView: View){
        myImg = parentView.findViewById<ImageView>(R.id.myimg)
        nameView = parentView.findViewById<TextView>(R.id.txtcust1)
       telNumView = parentView.findViewById<TextView>(R.id.txtcust2)
        EditView = parentView.findViewById<EditText>(R.id.btncust)
    }
}
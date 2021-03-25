package com.example.intent.exam

import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.intent.R

class ViewHolder {
    var myImg: ImageView? = null
    var nameView: TextView? = null
    var dateView: TextView? = null
    var checkBox_nameView: TextView? = null
    var checkBox:CheckBox? =null

    //UserViewHolder객체가 생성될때 targetView를 전달받는다.
    constructor(parentView: View){
        myImg = parentView.findViewById<ImageView>(R.id.imageView)
        nameView = parentView.findViewById<TextView>(R.id.name)
        dateView = parentView.findViewById<TextView>(R.id.date)
        checkBox_nameView = parentView.findViewById<TextView>(R.id.checkBox_name)
        checkBox = parentView.findViewById<CheckBox>(R.id.checkBox)
    }

}
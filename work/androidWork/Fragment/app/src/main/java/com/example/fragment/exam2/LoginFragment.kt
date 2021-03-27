package com.example.fragment.exam2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragment.R
import kotlinx.android.synthetic.main.activity_login_fragment.*
import kotlinx.android.synthetic.main.activity_register_fragment.*

class LoginFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_login_fragment,container,false)
        return view
    }

}
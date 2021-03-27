package com.example.fragment.exam2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.fragment.R
import kotlinx.android.synthetic.main.activity_fragment_exam02.*

class FragmentExam02 : AppCompatActivity() {
    val loginFragment = LoginFragment()
    val registerFragment = RegisterFragment()
    val infoFragment = InfoFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_exam02)
        supportFragmentManager.beginTransaction().add(R.id.exam2_container, loginFragment).commit()
    }

    fun btn2_click(view: View){
        Log.d("view","${view.getTag().toString()}")
        setFragment(view.getTag().toString())
    }

    fun setFragment(tag:String){
        var fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        when(tag){
            "login" -> {
                transaction.replace(R.id.exam2_container,loginFragment)
                transaction.addToBackStack("login")
            }
            "register" -> {
                transaction.replace(R.id.exam2_container,registerFragment)
                transaction.addToBackStack("register")
            }
            "info" -> {
                transaction.replace(R.id.exam2_container,infoFragment)
                transaction.addToBackStack("info")
            }

        }
        transaction.commit()
    }
}
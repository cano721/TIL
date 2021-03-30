package com.example.fragment.tabview.exam

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fragment.R
import com.example.fragment.change.exam.LoginFragment
import com.example.fragment.change.exam.MyPageFragment
import com.example.fragment.change.exam.RegisterFragment
import com.example.fragment.fragment.UserListFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_tab_test2.*

class TabExam : FragmentActivity() {
    var fragmentlist = ArrayList<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_test2)
        // 액션바와 탭 기본 설정부분
        setActionBar(toolbar2)
        toolbar2.setTitleTextColor(Color.WHITE)
        tabs2.setTabTextColors(Color.BLUE, Color.BLACK)

        // 프레그먼트 리스트 담기
        val loginFragment = LoginFragment()
        val myPageFragment = MyPageFragment()
        val registerFragment = RegisterFragment()
        val userListFragment = UserListFragment_Exam()
        fragmentlist.add(loginFragment)
        fragmentlist.add(myPageFragment)
        fragmentlist.add(registerFragment)
        fragmentlist.add(userListFragment)

        //어댑터 생성
        val adapter = object : FragmentStateAdapter(this){
            override fun getItemCount(): Int {
                return fragmentlist.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragmentlist[position]
            }
        }

        tab_viewPager2.adapter = adapter

        //탭과 뷰페이저2를 연결
        TabLayoutMediator(tabs2,tab_viewPager2){tab, position ->
            when(position){
                0 -> tab.text = "로그인"
                1 -> tab.text = "마이페이지"
                2 -> tab.text = "회원가입"
                3 -> tab.text = "유저목록"
            }
        }.attach()
    }
}
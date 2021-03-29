package com.example.fragment.tab

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.fragment.R
import com.example.fragment.change.exam.LoginFragment
import com.example.fragment.change.exam.MyPageFragment
import com.example.fragment.change.exam.RegisterFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_test1.*

class TabTest1 : AppCompatActivity() {
    val view1 = RegisterFragment()
    val view2 = LoginFragment()
    val view3 = MyPageFragment()
    val fragmentlist = ArrayList<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_test1)
        setSupportActionBar(toolbar)
//        fragmentlist.add(view1)
//        fragmentlist.add(view2)
//        fragmentlist.add(view3)
        toolbar.setTitleTextColor(Color.WHITE)
        tabs.setTabTextColors(Color.BLUE,Color.BLACK)
        //탭추가
        tabs.addTab(tabs.newTab().setText("설정"))
        //처음 실행할때 실행해서 보여줄 프래그먼트를 지정
       supportFragmentManager.beginTransaction().replace(R.id.tab_container1,view1).commit()

        //탭에 이벤트 연결하기
        tabs.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
            //탭이 선택될때 호출되는 메소드
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val position = tab?.position//탭의 순서를 받아오기
                Log.d("mytab","{$position}")
                var fragment:Fragment? = null
                when(position){
                    0 -> fragment = view1
                    1 -> fragment = view2
                    2 -> fragment = view3
                }
                supportFragmentManager.beginTransaction().replace(R.id.tab_container1,fragment!!).commit()
            }

        }) //end tab event

        bottomNavi.setOnNavigationItemSelectedListener(object :BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
//                Log.d("mytab","${item.toString()}")
                if(item.itemId == R.id.bottom_item1){
                    supportFragmentManager.beginTransaction().replace(R.id.tab_container1,view3).commit()
                }
                return false
            }

        })
    }

}
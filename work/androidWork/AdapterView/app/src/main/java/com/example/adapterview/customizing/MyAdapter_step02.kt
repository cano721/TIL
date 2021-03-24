package com.example.adapterview.customizing

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.adapterview.R
import kotlinx.android.synthetic.main.custrow.view.*

//코틀린에서 지원하는 .run을 이용해서 xml import기능을 이용해서 접근하기
class MyAdapter_step02(context: Context, var resId:Int, var datalist:ArrayList<User>):ArrayAdapter<User>(context,resId,datalist) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var start = System.nanoTime() //현재시간 측정

        //뷰를 생성하기 위해서 convertview를 활용 -화면을 만들기(LayoutInflater를 이용해서 직접 생성)
        val inflator = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var row_view = convertView
        row_view = inflator.inflate(resId,null) // inflate는 오버로딩되어 있으므로 필요한 것을 선택해서 작업

        var user = datalist[position]
        //코틀린에서 지원하는 기능
        row_view.run { //xml import가 가능하도록 한다.
            myimg.setImageResource(user.myImg)
            txtcust1.text = user.name
            txtcust2.text= user.telNum
            btncust.setOnClickListener {
                Log.d("getView","버튼이 눌려짐")
            }
        }
        val end = System.nanoTime()
        Log.d("getView","getview()=====>>(실행시간:${end-start}.position:${position})")
        return row_view//android os가 실행되는 과정에서 getView를 호출하며 화면을 만들 수 있도록 리턴
    }

    //매개변수로 전달받은 순서에 있는 리스트 한 항목을 반환
   override fun getItem(position: Int): User? {
        return datalist.get(position)
    }

    //리스트갯수를 반환
    override fun getCount(): Int {
        return datalist.size
    }
}
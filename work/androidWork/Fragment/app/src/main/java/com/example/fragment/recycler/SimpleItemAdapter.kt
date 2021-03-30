package com.example.fragment.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.simple_item.view.*

//RecyclerView에서 사용하는 Adapter를 커스트마이징
//Adapter안에 ViewHolder를 자체적으로 포함하고 있다. - 하위클래스로 구현(ViewHolder의 역할은 ListView와 동일)
//                                                  ----------------
//                                                  /_adapter의 inner클래스로 정의
//Context, row에 대한 디자인, row를 구성할 데이터
/*
    1. onCreateViewHolder메소드 내부에서 row에 대한 뷰를 inflate해서 생성
    2. ViewHolder객체에 생성한 view를 전달한다.
    3. ViewHodler객체 내부에서 매개변수로 전달받은 뷰를 이용하여 각 구성 요소를 ViewHolder에 저장
    4. onBindViewHolder메소드 안에서 ViewHolder가 저장ㅇ하고 있는 각 row를 구성하는 위젯에 데이터를 연결
 */
class SimpleItemAdapter(var context: Context, var itemlayout:Int, var datalist:ArrayList<SimpleItem>)
                                             : RecyclerView.Adapter<SimpleItemAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //항목으로 사용할 View객체 생성
        val itemView = LayoutInflater.from(context).inflate(itemlayout,null)
        val myViewHolder = MyViewHolder(itemView)
        return myViewHolder
    }

    //뷰를 만들고 뷰내부를 구성하는 위젯들에 데이터를 연결하는 작업
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //ViewHolder에서 텍스트뷰를 꺼내기
        var myTextView = holder.textView
        //viewHolder에서 꺼낸 텍스트뷰에 데이터 연결
        myTextView.text = datalist.get(position).title
        //ViewHolder에서 꺼낸 항목을 구성한 위젯인 TextView에 이벤트를 연결(이벤트연결은 viewHolder에서 할 수 있음)
    }

    //RecyclerView에 출력할 데이터의 갯수를 리턴
    override fun getItemCount(): Int {
        return datalist.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //매개변수로 전달받은 itemView에서 textview인 itemview_info를 추출해서
        //MyViewHolder의 멤버변수인 textview에 저장
        val textView = itemView.itemview_info
    }


}
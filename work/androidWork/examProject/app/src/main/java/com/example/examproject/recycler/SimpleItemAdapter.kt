package com.example.fragment.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.simple_item.view.*

class SimpleItemAdapter(var context: Context, var itemlayout:Int, var datalist:ArrayList<SimpleItem>)
                                             : RecyclerView.Adapter<SimpleItemAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(itemlayout,null)
        val myViewHolder = MyViewHolder(itemView)
        return myViewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //ViewHolder에서 텍스트뷰를 꺼내기
        var mydateView = holder.dateView
        //viewHolder에서 꺼낸 텍스트뷰에 데이터 연결
        mydateView.text = datalist.get(position).date + " " +  datalist.get(position).id + " " + datalist.get(position).ledstate
        //ViewHolder에서 꺼낸 항목을 구성한 위젯인 TextView에 이벤트를 연결(이벤트연결은 viewHolder에서 할 수 있음)
    }

    //RecyclerView에 출력할 데이터의 갯수를 리턴
    override fun getItemCount(): Int {
        return datalist.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //매개변수로 전달받은 itemView에서 textview인 itemview_info를 추출해서
        //MyViewHolder의 멤버변수인 textview에 저장
        val dateView = itemView.itemview_info
    }


}
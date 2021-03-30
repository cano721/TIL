package com.example.fragment.exam3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.circle_item.view.*
import kotlinx.android.synthetic.main.mypage.view.*
import kotlinx.android.synthetic.main.simple_item.view.*

class RecyclerCircleAdapter(var context: Context, var itemlayout:Int, var datalist:ArrayList<CircleItem>) : RecyclerView.Adapter<RecyclerCircleAdapter.MyViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemview = LayoutInflater.from(context).inflate(itemlayout,null)
        val myViewHolder = MyViewHolder(itemview)
        return myViewHolder
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var myCircleImg = holder.circleImg
        var img = datalist.get(position).img
        myCircleImg.setImageResource(img)

        //VIewHolder에서 꺼낸 항목을 구성한 위젯인 image에 이벤트 연결(이벤트 연결은 ViewHolder에서도 가능)
        myCircleImg.setOnClickListener {
            Toast.makeText(context,"이미지",Toast.LENGTH_LONG).show()
        }
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val circleImg = itemView.circleView
    }
}
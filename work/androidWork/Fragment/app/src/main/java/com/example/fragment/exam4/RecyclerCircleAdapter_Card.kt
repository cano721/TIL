package com.example.fragment.exam4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.circle_item.view.*
import kotlinx.android.synthetic.main.circle_item_card.view.*
import kotlinx.android.synthetic.main.mypage.view.*
import kotlinx.android.synthetic.main.simple_item.view.*

class RecyclerCircleAdapter_Card(var context: Context, var itemlayout:Int, var datalist:ArrayList<CircleItem_Card>) : RecyclerView.Adapter<RecyclerCircleAdapter_Card.MyViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemview = LayoutInflater.from(context).inflate(itemlayout,null)
        val myViewHolder = MyViewHolder(itemview)
        return myViewHolder
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //이미지 설정
        var myCardImg = holder.cardImg
        var img = datalist.get(position).img
        myCardImg.setImageResource(img)
        //타이틀 설정
        var myCardText = holder.cardText
        myCardText.text = datalist.get(position).title
        //레이아웃 따오기
        var cardLayout = holder.cardLayout

        //VIewHolder에서 꺼낸 항목을 구성한 위젯인 layout에 이벤트 연결(이벤트 연결은 ViewHolder에서도 가능)
        cardLayout.setOnClickListener {
            Toast.makeText(context,"카드선택",Toast.LENGTH_LONG).show()
        }
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val cardImg = itemView.cardView
        var cardText = itemView.cardText
        var cardLayout = itemView.cardLayout
    }
}
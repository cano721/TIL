package com.example.adapterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adapterview.customizing_exam.ExamAdapter
import com.example.adapterview.customizing_exam.Person
import kotlinx.android.synthetic.main.select_exam_main.*

class SelectView_ExamActivity : AppCompatActivity() {
    val actorlist = ArrayList<Person>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.select_exam_main)
        //1. 리스트에 출력할 데이터 받기
        var actorItem: Person
            actorItem = Person(R.drawable.ansoccer, "안정환", "2021/04/06", "멋져")
            actorlist.add(actorItem)
            actorItem = Person(R.drawable.chasoccer, "차범근", "2021/04/06", "아들~~")
            actorlist.add(actorItem)
            actorItem = Person(R.drawable.jjangkim, "김어준", "2021/04/06", "찐")
            actorlist.add(actorItem)
            actorItem = Person(R.drawable.kbr, "김범룡", "2021/04/06", "진짜가수")
            actorlist.add(actorItem)
            actorItem = Person(R.drawable.kimdong, "이민호", "2021/04/06", "멋져")
            actorlist.add(actorItem)
            actorItem = Person(R.drawable.leemin, "이민호", "2021/04/06", "멋져")
            actorlist.add(actorItem)
            actorItem = Person(R.drawable.parksoccer, "박지성", "2021/04/06", "멋져")
            actorlist.add(actorItem)
            actorItem = Person(R.drawable.ansoccer, "안정환", "2021/04/06", "멋져")
            actorlist.add(actorItem)
            actorItem = Person(R.drawable.chasoccer, "차범근", "2021/04/06", "아들~~")
            actorlist.add(actorItem)
            actorItem = Person(R.drawable.jjangkim, "김어준", "2021/04/06", "찐")
            actorlist.add(actorItem)
            actorItem = Person(R.drawable.kbr, "김범룡", "2021/04/06", "진짜가수")
            actorlist.add(actorItem)
            actorItem = Person(R.drawable.kimdong, "이민호", "2021/04/06", "멋져")
            actorlist.add(actorItem)
            actorItem = Person(R.drawable.leemin, "이민호", "2021/04/06", "멋져")
            actorlist.add(actorItem)
            actorItem = Person(R.drawable.parksoccer, "박지성", "2021/04/06", "멋져")
            actorlist.add(actorItem)

        //2. 어댑터 생성
        val adapter = ExamAdapter(this,R.layout.select_exam_row,actorlist)

        //3. listview에 어댑터연결
        actorview.adapter = adapter


    }
}
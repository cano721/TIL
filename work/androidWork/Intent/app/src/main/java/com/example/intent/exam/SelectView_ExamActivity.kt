package com.example.intent.exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import com.example.intent.R
import kotlinx.android.synthetic.main.select_exam_main.*

class SelectView_ExamActivity : AppCompatActivity() {
    val actorlist = ArrayList<Person>()
    var curentView:ViewHolder?= null
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
        val adapter = ExamAdapter(this,R.layout.select_exam_row2,actorlist)

        val mylistener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Log.d("test","test")
            var listIntent = Intent(this@SelectView_ExamActivity,ListItemDetailActivity::class.java)
            var myobj = PersonValue()
            myobj.myImg =actorlist[position].myImg
            myobj.name =actorlist[position].name
            myobj.checkBox_name =actorlist[position].checkBox_name
            myobj.date =actorlist[position].date

            listIntent.putExtra("myobj",myobj)
            curentView = view.getTag() as ViewHolder
            startActivityForResult(listIntent,100)
        }
//        //3. listview에 어댑터연결
//        actorview.adapter = adapter
//
//        actorview.onItemClickListener = mylistener
        actorview.onItemClickListener = mylistener
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==100){
            if(resultCode==111){
                var myobj = data?.getParcelableExtra<PersonValue>("myobj")
                val check = data?.getBooleanExtra("check",false)
                curentView?.checkBox?.isChecked = check!!
                curentView?.nameView?.text = myobj?.name
                curentView?.dateView?.text = myobj?.date
                curentView?.checkBox_nameView?.text = myobj?.checkBox_name
                //데이터를 DB나 파일에서 가져왔을때 에이터로 DB나 파일의 내용까지 변경하는 코드 추가

            }
        }

    }
}
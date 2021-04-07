package com.example.datamanagement.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.datamanagement.R
import kotlinx.android.synthetic.main.dbjob_main.*

class ContentValuesTestActivity : AppCompatActivity() {
    var dao:MyTableDB? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dbjob_main)
        dao = MyTableDB(this)
        save.setOnClickListener {
            //Integer.parseInt(age.text.toString()) 문자열을 인트형으로 변환
            var myperson = Person(id.text.toString(),name.text.toString(),Integer.parseInt(age.text.toString()))
            dao?.insert(myperson)
            id.setText("")
            name.setText("")
            age.setText("")
            Toast.makeText(this,"삽입성공", Toast.LENGTH_LONG).show()
            selectData()
        }
        find.setOnClickListener {
            selectData()
            }
        update.setOnClickListener {
            dao?.update(id.text.toString(),age.text.toString()) //update를 호출하면서 액티비티에서 입력한 값을 넘기기
            selectData()
        }
        del.setOnClickListener {
            dao?.delete(id.text.toString())
            selectData()
        }
        }
        fun selectData(){
            result.setText("")
            val datalist:ArrayList<Person>? = dao?.select()
            Toast.makeText(this,"ArrayList로 변환된 데이터:${datalist!!.size}",Toast.LENGTH_LONG).show()
            for(i in datalist.indices){
                var data = datalist[i]
                Log.d("mydbtest","번호:${data.idx}\n 아이디:${data.id}\n 성명:${data.name}\n 나이:${data.age}\n==================\n")

                result.append("번호:${data.idx}\n 아이디:${data.id} \n 성명:${data.name} \n 나이:${data.age} \n===========================\n")
            }
    }
}
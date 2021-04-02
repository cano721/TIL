package com.example.datamanagement.sqlite

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.datamanagement.R
import kotlinx.android.synthetic.main.dbjob_main.*

class DBTestMainActivity : AppCompatActivity() {
    var mydb:SQLiteDatabase ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dbjob_main)
        //1. DBHelper 생성
        var helper = DBHelper(this)
        //getWritableDatabase()를 호출해서 SQLiteDatabase객체를 만들기
        mydb = helper.writableDatabase
        save.setOnClickListener {
            val sql = """
                insert into mytable(id,name,age) values(?,?,?)
            """.trimIndent()
            mydb?.execSQL(sql, arrayOf(
                id.text.toString(), name.text.toString(), age.text.toString()
            ))
            Toast.makeText(this,"삽입성공",Toast.LENGTH_LONG).show()
        }
        find.setOnClickListener {
            select()
        }
        update.setOnClickListener {
            update()
            result.text = ""
            select()
        }
        del.setOnClickListener {
            delete()
            result.text = ""
            select()
        }
    }
    fun select(){
        var sql = "select * from mytable"
        val cursor:Cursor = mydb!!.rawQuery(sql,null)
        val count = cursor.count //조회한 row의 갯수
        Toast.makeText(this,"조회된 row:$count", Toast.LENGTH_LONG).show()
        Toast.makeText(this,"조회된 row:$count",Toast.LENGTH_LONG).show()
        while(cursor.moveToNext()){ //테이블내부에서 커서를 다음 레코드로 이동(레코드가 존재하면true, 없으면 false를 리턴)
            val idx = cursor.getInt(0)
            val id = cursor.getString(1)
            val name = cursor.getString(2)
            val age = cursor.getString(3)
            result.append("번호:$idx\n 아이디:$id \n 성명:$name \n 나이:$age \n============================\n")
        }
    }
    fun update(){
        val sql = "update mytable set age = ? where id = ?"
        val argsArr = arrayOf(age.text.toString(),id.text.toString())
        mydb!!.execSQL(sql,argsArr)

    }
    //db처리에 관련된 메소드는 db에 관련된 작업만 처리
    fun delete(){
        val sql = "delete from mytable where id = ?"
        val argsArr = arrayOf(id.text.toString())
        mydb!!.execSQL(sql,argsArr)
    }
}
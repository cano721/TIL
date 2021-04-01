package com.example.datamanagement.sqlite

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.datamanagement.R
import kotlinx.android.synthetic.main.dbjob_main.*

class DBTestMainActivitiy : AppCompatActivity() {
    var mydb:SQLiteDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dbjob_main)
        //1. DBHe
        var helper = DBHelper(this)

        //
        mydb = helper.writableDatabase
        save.setOnClickListener {
            val sql = """
                insert into mytable(id,name,age) values(?,?,?)
            """.trimIndent()
            mydb?.execSQL(sql,arrayOf(
                id.text.toString(),name.text.toString(),age.text.toString()
            ))
            Toast.makeText(this,"삽입성공",Toast.LENGTH_LONG).show()
        }
        find.setOnClickListener {
            val sql = "select * from mytable"
            val cursor: Cursor = mydb!!.rawQuery(sql,null)
            val count = cursor.count // 조회한 row의 갯수
            Toast.makeText(this,"조회된row:$count",Toast.LENGTH_LONG).show()
        }
    }
}
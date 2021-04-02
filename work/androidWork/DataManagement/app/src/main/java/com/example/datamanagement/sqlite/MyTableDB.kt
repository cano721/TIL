package com.example.datamanagement.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

//test.db파일에 저장된 myTable테이블에 CRUD기능을 처리하는 객체
class MyTableDB {
    var contenValObj:ContentValues? = null
    var mydb: SQLiteDatabase? = null
    constructor(context: Context){
        var helper = DBHelper(context)
        mydb = helper.writableDatabase
    }
    fun insert(person: Person){
        //데이터저장하기
        //매개변수로 전달된 Person객체에 저장된 데이터를 SQLite에 insert하기
        contenValObj = ContentValues()
        contenValObj!!.put("id",person.id)
        contenValObj!!.put("name",person.name)
        contenValObj!!.put("age",person.age)
        //insert내부에서 insert기능을 처리할 수 있는 sql문을 생성한다. 이때 필요한 컬럼에 전달할 값 등은 ContentValues에서 추출
        mydb?.insert("mytable",null,contenValObj)
    }
    fun select(){

    }
    fun update(){

    }
    fun delete(){

    }

}
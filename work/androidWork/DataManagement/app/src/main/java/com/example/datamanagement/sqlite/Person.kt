package com.example.datamanagement.sqlite

//테이블의 레코드를 저장할 객체
class Person {
    var idx:Int = 0
    var id:String = ""
    var name:String = ""
    var age:Int = 0

    constructor(id:String, name:String, age:Int){
        this.id = id
        this.name = name
        this.age = age
    }

    override fun toString(): String {
        return "Person(idx=$idx, id='$id', name='$name',age=$age)"
    }
}
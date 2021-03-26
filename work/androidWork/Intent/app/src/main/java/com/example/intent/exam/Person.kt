package com.example.intent.exam

class  Person {
    var myImg = 0 // 이미지 리소스
    var name:String?=null //이름
    var date:String?=null //날짜
    var checkBox_name:String?=null //체크박스이름

    constructor(myImg: Int, name: String?, date: String?, checkBox_name: String?) {
        this.myImg = myImg
        this.name = name
        this.date = date
        this.checkBox_name = checkBox_name
    }
}
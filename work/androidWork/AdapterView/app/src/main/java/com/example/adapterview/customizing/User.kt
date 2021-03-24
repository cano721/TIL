package com.example.adapterview.customizing

//row에 출력할 데이터 정보를 담는 객체 - 리스트뷰 항목에 출력할 데이터를 편하게 관리하기 위해서 만든 클래스
class User {
    var myImg = 0 // 이미지 리소스
    var name:String?=null //이름
    var telNum:String?=null //전화번호
    constructor(myImg:Int,name:String?,telNum:String){
        this.myImg = myImg
        this.name =name
        this.telNum = telNum
    }

    override fun toString(): String {
        return "User{"+
                "myImg=" + myImg +
                ",name=" + name +
                ",telNum" + telNum
    }
}
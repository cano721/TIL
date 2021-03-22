package kr.multicampus.kotlin.oop.ploy

class SMSSender(name:String ,var length:Int):Sender(name) {
    override fun send(){
        println("$name 에게 SMS으로 전송하기")
    }
}
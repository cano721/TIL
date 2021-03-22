package kr.multicampus.kotlin.oop.ploy

class SNSSender(name:String ,var length:Int):Sender(name) {
    override fun send(){
        println("$name 에게 SNS으로 전송하기")
    }
}
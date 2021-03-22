package kr.multicampus.kotlin.oop.ploy

class EmailSender(name:String ,var length:Int):Sender(name){
    override fun send(){
        println("$name 에게 email으로 전송하기")
    }
}

package kr.multicampus.kotlin.oop.ploy

import java.util.*

fun main() {
    val key: Scanner = Scanner(System.`in`);
    println("""***************계산기******************
        |1. Email전송
        |2. SMS
        |3. SNS
    """.trimMargin());
    print("원하는 작업을 선택하세요:");
    val selectVal:Int = key.nextInt();
    val logic:SenderLogic = SenderLogic()
    var senderObj:Sender ?= null
    when(selectVal){
        1 -> {
            senderObj = EmailSender("계해범",100)
        }
        2 -> {
            senderObj = SMSSender("계해범",100)
        }
        3 -> {
            senderObj = SNSSender("계해범",100)
        }
    }
    logic.run(senderObj)
}

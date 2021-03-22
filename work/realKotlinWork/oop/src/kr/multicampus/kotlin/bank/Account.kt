package kr.multicampus.kotlin.bank
import java.util.Scanner

class Account(var accld:String,var balance:Int){
    var key:Scanner = Scanner(System.`in`)

    fun deposit(){
        println("입금할 금액입력:")
        var money = key.nextInt()
        balance += money
    }

    fun withdrawal(){
        println("출금할 금액입력:")
        var money = key.nextInt()
        if(money <= balance){
            balance -= money
        }
        else{
            println("잘못입력하셨습니다.")
        }
    }

    fun check(){
        println("계좌번호:$accld,잔액:$balance")
    }
}
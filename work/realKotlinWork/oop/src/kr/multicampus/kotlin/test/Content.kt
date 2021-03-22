package kr.multicampus.kotlin.test

abstract class Content(var title:String) {
    var price:Int = 0

    abstract fun totalPrice()
    fun show(){
        println("$title 가격은 $price 원입니다.")
    }
}
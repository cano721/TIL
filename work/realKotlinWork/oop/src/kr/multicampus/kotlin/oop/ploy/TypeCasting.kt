package kr.multicampus.kotlin.oop.ploy

fun main(){
    //obj1은 subA타입이고 SubA객체를 참조하고 있다.
    val obj1: SubA = SubA()
    obj1.display()
    obj1.show()
    obj1.test()
    println("*************************")
    //상속관계에 있는 경우 상위타입으로 변수를 선언하고 하위객체를 생성해서 참조할 수 있다.
    //=> 묵시적으로 형변환이 발생, 코틀린에서는 이를 스마트형변환이라 한다.
    val obj2: SuperA = SubA()
    //
    obj2.display()
    //obj2.show() //subA타입으로 접근할 수 있다.
    obj2.test()
}

open class SuperA{
    fun test(){
        println("Super의 test")
    }
    open fun display(){
        println("Super의 display")
    }
}

class SubA: SuperA(){
    fun show(){
        println("Show")
    }
    override fun display(){
        println("Sub의 display")
    }
}
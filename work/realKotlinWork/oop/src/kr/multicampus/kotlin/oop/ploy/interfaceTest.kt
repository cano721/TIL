package kr.multicampus.kotlin.oop.ploy

fun main(){
    //SubInter타입가능 ( 전체사용가능)
    val obj1:SubInter = SubInter()
    obj1.method()
    //SuperInter타입으로 선언이 가능 -부모클래스내 메소드만 사용 가능
    val obj2:SuperInter = SubInter()
    obj2.test()
    //Inter1이라는 interface를 구현하고 있으므로(구현은 상속처럼 취급) Inter1타입으로 정의 가능
    val obj3:Inter1 = SubInter()
    obj3.display()
    //Inter2타입으로 정의 가능 - 인터페이스내 메소드만 사용 가능
    val obj4:Inter2 = SubInter()
    obj3.display()
}

interface Inter1{
    fun display()
}
interface Inter2{
    fun show()
}

open class SuperInter{
    fun test(){
        println("SuperInter클래스의 일반 메소드")
    }
}
class SubInter:SuperInter(),Inter1,Inter2{
    fun method(){
        println("내 메소드")
    }
    override fun display() {
        println("Inter의 추상메소드 display오버라이딩")
    }
    override fun show() {
        println("Inter의 추상메소드 show오버라이딩")
    }
}

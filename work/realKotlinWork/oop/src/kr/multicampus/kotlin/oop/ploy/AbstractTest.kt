package kr.multicampus.kotlin.oop.ploy

fun main(){
    val obj1 = Child()
    obj1.display()
    obj1.show()
}
open abstract class Parent{
    fun display(){
        println("Parent의 일반메소드")
    }
    //추상메소드
    open abstract fun show()
}

//상속받은 클래스가 추상메소드를 가지고 있으면 반드시 오버라이딩을 해야 한다.
class Child: Parent(){
    override fun show() {
        println("오버라이딩된 추상메소드")
    }

}
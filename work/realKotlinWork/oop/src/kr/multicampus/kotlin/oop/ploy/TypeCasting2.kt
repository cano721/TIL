package kr.multicampus.kotlin.oop.ploy
fun main(){
    val obj1: SubB = SubB()
    obj1.display()
    val obj2: SuperB = SuperB()
    obj2.display()

    //부모타입 = 자식객체 O
    val obj3: SuperB = SubB()
    obj3.display()
    //obj3.show() 불가능

    //자식클래스타입 = 부모객체 x
    //val obj4:SubB = SuperB()
    val obj4: SuperB = obj1;
    obj4.display()

    //as라는 연산자
    //객체참조변수를 as 뒤에 정의된 클래스타입으로 변경하는 연산자
    //[형식] 참조변수 as 클래스타입
    obj3 as SubB
    obj4 as SubB
    obj3.show()
    obj4.show()
    // obj2 as SubB 는 불가능 SubB에 Super를 못담음

}
open class SuperB{
    fun test(){
        println("Super의 test")
    }
    open fun display(){
        println("Super의 display")
    }
}

class SubB: SuperB(){
    fun show(){
        println("Sub의 show")
    }
    override fun display(){
        println("Sub의 display")
    }
}
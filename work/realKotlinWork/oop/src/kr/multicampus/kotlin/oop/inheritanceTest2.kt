package kr.multicampus.kotlin.oop
//*********************상속연습************************


//상속 모든클래스에 공통(중복)으로 정의해야하는 구성 요소를 하나의 클래스에 정의한 후 사용할 수 있도록 하는 기능

//상위 클래스  open을 이용해서 상속이 가능한 클래스로 만들어야한다
// open class 클래스명 (){}

//하위 클래스 class(): 상위클래스명(){

fun main(){
    val obj1:SubClass = SubClass()
    println("obj1의 객체로 부모 클래스의 멤버변수 접근:${obj1.superVal}")
    obj1.display()
    val obj2:SubClass2 = SubClass2()
    println("obj1의 객체로 부모 클래스의 멤버변수 접근:${obj2.superVal}")
    obj2.display()
}
//class를 정의하면 코틀린이 컴파일되고 자바코드로 변환되면서 public final이 추가
/*
    final의 의미
    변수: 상수
    메소드: 재정의할 수 없는 메소드
    클래스: 상속할 수 없는 클래스
 */

open class SuperClass{
    var superVal = 100
    fun display(){
        println("부모클래스의 display")
    }
}

//클래스를 상속하는 경우 반드시 상위클래스의 생성자를 호출해야 한다.
//상위클래스의 주 생성자를 주로 호출한다.
//상위클래스에 생성자가 정의되어 있지 않으면 매개변수가 없는 생성자를 호출한다.
class SubClass:SuperClass(){

}
class SubClass2:SuperClass{
    constructor():super() {//SubClass2의 객체가 생성되면 부모의 매개변수없는 생성자를 머저 호출한다.
    }
}
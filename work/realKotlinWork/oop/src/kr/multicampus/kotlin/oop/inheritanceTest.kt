package kr.multicampus.kotlin.oop
//1. 상속구조로 변경
//2. car클래스에 name변수를 초기화하는 생성자를 주생성자로 정의
// 나머지 하위클래스가 생성자를 활용해서 작업할 수 있도록 변경


fun main(){
    val car1:Bus = Bus("버스")
    car1.달린다()

    val car2:Truck = Truck("트럭")
    car2.달린다()

    val car3:Taxi = Taxi("택시")
    car3.달린다()

}
open class Car(var 종류:String){
    val 제조사:String=""
    val 색상:String=""

    constructor():this(""){

    }
    fun 달린다() {
        println("${종류}가(이) 달린다.")
    }

    fun 속도올리기() {

    }

    fun 속도내리기() {

    }
}

class Bus:Car{
    constructor(종류:String):super(종류){
        //subclass2의 객체가 생성되면 부모의 매개변수 없는 생성자를 먼저호출
    }
    val 인원수:Int=0
    fun 노선확인하기(){

    }
}

//Truck에는 주생성자로 종류변수에 값을 전달받을 수 있도록 생성자가 정의되어 있고
//Truck이 생성될때 부모클래스인 Car의 주생성자를 호출하며 전달
class Truck(종류:String):Car(종류){
    val 무게:Int= 0
    fun 짐올리기(){

    }
}

class Taxi(종류:String):Car(종류){
    val 기본요금:Int=0
    fun 손님태우기(){

    }
}
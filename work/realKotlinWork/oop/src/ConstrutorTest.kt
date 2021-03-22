fun main(){
    val obj1:Customer = Customer()
    val obj2:Customer = Customer(45,10101111)
    val obj3:Customer2 = Customer2(65,7777777)
    obj2.print()
    println("Person의 age:${obj3.age}")
    println("Person의 telNum:${obj3.telNum}")

    val obj4:Customer = Customer(10,20)
    println("Person의 age:${obj3.age}")
    println("Person의 telNum:${obj3.telNum}")

    val obj5:Customer4 = Customer4(10,"이민호",1111)
    println("Person의 age:${obj5.age}")
    println("Person의 telNum:${obj5.telNum}")
    println("Person의 name:${obj5.name}")
}

//객체가 생성되면 init -> 생성자가 호출
//init은 객체가 생성될때 처리하는 작업을 하는 코드블럭
//custructor는 멤버변수를 바꾸는 작업을할때 쓰는 생성자
class Customer{
    var age:Int = 0
    var telNum:Int = 0
    constructor(){
        println("매개변수가 없는 생성자")
    }
    constructor(age:Int,telNum:Int){
        this.age = age
        this.telNum =telNum
    }
    init {
        println("객체가 생성될때 자동으로 실행되는 블럭")
    }
    fun print(){
        println("print=> age:$age,telnum:$telNum")
    }
}

class Customer2 constructor(var age:Int,var telNum:Int) {
}

//클래스를 선언하며 생성자를 바로 정의하는 경우 constructor의 생략이 가능
class Customer3 (var age:Int,var telNum:Int) {
}
//생성자 정의하기 -3
//2번방법의 확장
//기본생성자는 반드시 초기화해야 하는 변수를 정의
class Customer4(var age:Int,var name:String){
    var telNum:Int = 0 //보조생성자
    //생성자 오버로딩이 가능하므로 여러 개를 정의하고 사용할 수 있다.
    //주생성자(기본생성자) 이외의 생성자를 보조생성자라 부른다.
    //주생성자(기본생성자)를 정의하는 경우 반드시 보조생성자를 정의할때
    // 주생성자(기본생성자)를 호출해서 값을 셋팅해줘야 한다.
    //constructor(...,telNum:Int):this(...)
    constructor(age:Int,name:String,telNum:Int):this(age,name){
        this.telNum = telNum
    }
}

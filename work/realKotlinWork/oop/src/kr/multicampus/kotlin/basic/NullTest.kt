package kr.multicampus.kotlin.basic

fun main(){
    //1. !!연산자
    var num1:Int = 100 // null을 허용하지 않는 변수
    var num2:Int? = null // null을 허용하는 변수

    //num2변수는 null이나 null이 아닌 값을 모두 저장할 수 있는 변수이므로 가능
    //num2 = num1

    //Int와 Int?
    //null을 허용하지 않는 변수에 null을 허용하는 변수를 할당하는 것은 에러
    //!!연산자를 사용하면 컴파일에러가 발생하지 않는다. 하지만 NullPointerException이 뜸
    //num1 = num2!!

    test("오늘은 신나는 금요일")
    //!!연산자는 널을 허용하는 변수를 널을 허용하지 않는 변수의 타입으로 변경
    //null아닌 경우에는 잘 실행이 되는데 null인 경우에는 이미 null값이 저장되어 있으므로 변경할 수 없고 Exception을 발생
    //null인 경우 안정성을 보장받지 못하고 오류가 발생


    //2. ?:연산자
    //?:연산자는 null이 아닌 값이 전달되면 변수에 전달된 값을 사용하고 null전달되면 기본으로 정의된 객체가 사용
    //test2함수의 경우 str에 null이 아닌 값이 전달되면 str을 그냥 사용하고 str에 null이 전달되면 기본으로 정의한
    //"나는 지금 작업중"이라는 문자열을 사용하겠다는 의미
    println("***********************************")
    test2("오늘은 신나는 금요일")
    test2(null)
    //3. ?.연산자
    //null인 경우 오류를 발생시키지 않고 null을 반환
    println("***********************************")
    test3("오늘은 신나는 금요일")
    test3(null)
}
fun test(str:String?){//매개변수로 전달되는 str은 null을 허용
    val myVal:String = str!!
    println("myVal:$myVal")
}

fun test2(str:String?){
    val myVal:String = str ?:"나는 지금 작업중"
    println("myVal:$myVal")
}

fun test3(str:String?){
    println("myVal:$str")
    //str은 null을 허용하는 변수이므로 /이 아니라 ?. 연산자를 통해 접근
    println("str문자열의 길이:${str?.length}")
}
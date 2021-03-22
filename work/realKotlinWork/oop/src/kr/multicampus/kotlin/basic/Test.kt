fun main() {
    print("hello")
    print("hello")
    print("hello")

    println("hello")
    println("hello")
    println("hello")
    //
    /*


     */
    println("test:" +100)
    println("test:${100}")

    //출력형태
    println("코틀린을 이용한\n 안드로이드 \n개발 \n- 아두이노제어하기")
    println("""코틀린을 이용한
                |안드로이드 
                |개발 
                |- 아두이노제어하기""".trimMargin())

    //변수선언
    /*
        1. 데이터타입
            1) 정수 : Long(8), Int(4), Short(2), Byte(1)
            2) 부호가 없는 정수: ULong(8), UInt(4), UShort(2), UByte(1)
            3) 실수: Double(8), Float(4)
            4) 논리값: Boolean(1)
            5) 문자: Char(2)
            6) 문자열: String

        2. 변수선언
            1) 방법
                var 변수명:타입 = 값
                val 변수명:타입 = 값
            2) 코틀린은 데이터타입을 생략하게 되면 할당된 값을 기준으로 자동으로 데이터타입을 결정한다.
                => 코틀린에서는 자료형을 생략하는 것을 추천
            3) val과 var의 차이점
                -val키워드로 선언된 변수는 초기에 셋팅한 값을 변경할 수 없다.
                -var키워드로 선언된 변수는 초기에 셋팅한 값을 변경할 수 있다.
            4) null처리를 정교하게
                - null값을 저장할 수 있는 변수와 저장할 수 없는 변수로 나누어서 관리
                - var 변수명:타입 = null의 형식으로 선언하는 변수는 null값을 셋팅할 수 없다.
                - var num6:Int ?=null의 형식으로 변수를 선언하면 null을 허용하는 변수가 된다.
                - null을 허용하지 않는 변수에 null을 허용하는 변수의 값을 할당할 수 없다.
                - null을 허용하지 않는 변수에 null을 허용하는 변수의 값을 할당하기 위해서 !!를 뒤에 추가하면 된다.
                    var num6:Int ?= null
                    var num7:Int = num6!!

     */
    val num1:Int = 100
    val num2:Int = 200
    val result:Int = num1+num2
    //변수명만 사용하는 경우는 {}생략이 가능하나 연산식을 사용하는 경우 {}를 생략할 수 없다.
    println("num1:${num1},num2:${num2}를 더한 결과:$result")

    val result2 = num1+num2
    println("result2:$result2")

    //val과 var의 차이
    val num3:Int = 100
    var num4:Int = 200

    println("num3:${num3}")
    println("num4:${num4}")

    //num3 = 200 중간에 변동 안됨
    num4 = 300

    //null에 대한 처리
    var num5:Int = 100
    var num6:Int ?= null

    //num5 = num6
    //num6 = num5 //null을 허용하는 변수 = null을 허용하지 않는 변수 ----> 0
    //var num7:Int = num6!! -널포인트익셉션이 뜸(null값으로 무언갈 할려고해서!)
}
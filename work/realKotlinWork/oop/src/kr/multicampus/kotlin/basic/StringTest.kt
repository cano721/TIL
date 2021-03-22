package kr.multicampus.kotlin.basic
/*

    String
        - 불변(원본이 변경되지 않는다.)
            => 메소드의 처리결과로 String객체가 새로 만들어진다.
            => +연산자를 이용해서 문자열을 연결하는 직업을 하면 String객체가 갯수만큼 메모리에 생성
        - 배열로 관리
        - 0번부터 index발생

    StringBuffer
        - 문자열조작이 가능
        - 원본이 변경된다.
 */

fun main(){
    val str = "hello"
    //str = str+ "~~~~"
    println("str[0] =>${str[0]}")
    println("str[0] =>${str[1]}")
    println("str.equals('hello') =>${str.equals("hello")}")
    println("str.equals('hello') =>${str.equals("HELLO")}") //대소문자 구분 해줘야함
    println("str.toUpperCase()=>${str.toUpperCase()}")
    println("str=>${str}")
    println(str.length)
    println(str.substring(str.length-1,str.length))
    println("****** ***********************************")
    val str2 = "python android c java kotlin"
    val strdata = str2.split(" ")
    println("strdata:${strdata[0]}")

    val sb1 = StringBuffer()
    sb1.append("java")
    sb1.append("kotlin")
    sb1.append("android")
    sb1.append("python")
    println("sb1:$sb1")

    sb1.insert(2,"한글")
    println("sb1:$sb1")

}

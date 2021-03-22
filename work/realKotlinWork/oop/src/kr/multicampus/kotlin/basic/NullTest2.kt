package kr.multicampus.kotlin.basic

fun main(){
    testMethod("안녕")
}

//스마트캐스팅 - 자동형변환
//=> null에 대한 작업을 하는 경우 null이 아니라는 확실한 코드를 주면 스마트캐스팅이 발생
fun testMethod(str:String?){
    println(str?.length)
    //매개변수가 nuill이 아니라는 명확한 조건만 주면 스마트캐스팅
    if(str!=null){
        //str에 대한 캐스팅 - if문을 벗어나면 원래타입
        println(str.length)
    }
    if(str is String){
        //스마트캐스팅이 발생
        println(str.length)
    }
    //println(str.length)
}
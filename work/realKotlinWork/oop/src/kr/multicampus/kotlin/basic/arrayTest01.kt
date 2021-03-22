fun main(){
    /*
        배열
        1. 다양한 타입의 데이터를 배열에 저장할 수 있다.
            => 한 가지 타입으로 제한할 수 있다.
        2. 배열을 생성하는 방법
            - 함수로 선언과 생성과 초기화를 한번에 작업 : arrayOf
            - Array객체로 관리
        3. 배열은 객체로 관리
        4. 배열을 사용하려면 배열을 생성해야 한다.
            -arrayOf함수를 이용해서
            
     */
    val myarr1 = arrayOf(10,20,30,40,50)
    println("myarr1:$myarr1")
    println("myarr1:${myarr1.contentToString()}")
    println("myarr1:${myarr1[0]}")
    println("myarr1:${myarr1[1]}")
    display(myarr1)
}
//배열이 매개변수인 함수
fun display(myarr:Array<Int>){
    println("display함수 =>${myarr.contentToString()}")
}
import java.util.Scanner

fun main(){
    //실습을 위해서 외부에서 키보드로 입력하는 다양한 타입의 데이터를 변수에 저장하고 사용하는 방법
    //표준입력: 키보드입력
    //표준입력을 제어하기 위한 코틀린 객체(자바객체) Scanner
    /*
        next() : space bar, enter키를 누르기 전에 입력한 단어를 String으로 리턴
        nextInt(): space bar, enter키를 누르기 전에 입력한 단어를 Int으로 리턴
        nextLine() : 한 문장을 읽어서 리턴 - \n을 포함한 문자열을 읽는다.
     */
    val key:Scanner = Scanner(System.`in`);
    print("성명:")
    val name:String = key.next()
    print("나이:")
    val age:Int = key.nextInt()
    print("비고:")
    key.nextLine()
    val info:String = key.nextLine()
    println("name:$name,age:$age")
    println("info:$info")
}
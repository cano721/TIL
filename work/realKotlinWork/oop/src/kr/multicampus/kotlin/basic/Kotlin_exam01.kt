import java.util.Scanner

fun main(){
    val scan:Scanner = Scanner(System.`in`)

    println("계산기")
    println("1.더하기\n2.빼기\n3.곱하기\n4.나누기")
    print("원하는작업을 선택하세요:")
    val choice = scan.nextInt()
    println("숫자1:")
    val num1 = scan.nextInt()
    println("숫자2:")
    val num2 = scan.nextInt()
    val result = calc(choice,num1,num2)
    println("연산결과:$result")
}

fun calc(choice:Int,num1:Int,num2:Int) =
    when(choice){
        1 -> num1 + num2
        2 -> num1 - num2
        3 -> num1 * num2
        4 -> num1 / num2
        else -> "잘못입력하셨습니다."
    }

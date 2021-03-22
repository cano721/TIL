import java.util.Scanner

fun main(){
    var result = display('c')
    println("'c'는 $result")
    result = display('3')
    println("'3'는 $result")
    result = display('C')
    println("'C'는 $result")
    result = display('!')
    println("'!'는 $result")

    val scan:Scanner = Scanner(System.`in`)
    println("printdata함수")
    println("숫자1:")
    val num1 = scan.nextInt()
    println("숫자2:")
    val num2 = scan.nextInt()
    printdata(num1..num2)

    val myarr = arrayOf(10,20,30,40,50)
    printSumArray(myarr)
}
fun display(a:Char) = when(a){
    in '0'..'9' -> "숫자입니다."
    in 'a'..'z' -> "문자입니다."
    in 'A'..'Z' -> "문자입니다."
    else -> "판단할 수 없습니다."
}

fun printdata(num:IntRange){
    for(i in num){
        if(i%3 == 0){
            println(i)
        }
    }
}

fun printSumArray(arr:Array<Int>){
    var sum:Int = 0
    for(i in arr) {
        sum += i
    }
    println("합계$sum")
    println("합계${sum/(arr.size)}")
}
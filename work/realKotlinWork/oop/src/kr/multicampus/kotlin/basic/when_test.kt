fun main(){
    /*
        when switch문과 비슷
        1. 형식
            when(변수 or 연산식){ -> 변수나 연산식으로 평가
                값1 -> 실행할 코드
                값2 -> 실행할 코드
                값3 -> 실행할 코드
                값4 -> 실행할 코드
                .....
                else -> 정의한 값을 만족하지 않는 경우
                }
     */
    val code =1
    when(code){
        1 -> println("입력에 관련된 작업을 수행")
        2 -> println("출력에 관련된 작업을 수행")
        3 -> println("조회에 관련된 작업을 수행")
        else -> println("값 잘못 입력")
    }
    println()
    val code2 =3
    when(code2){
        1,2 -> println("입력에 관련된 작업을 수행")
        3,4 -> {
                println("출력에 관련된 작업을 수행")
                println("비밀번호 입력")
        }
        5,6 -> println("조회에 관련된 작업을 수행")
        else -> println("값 잘못 입력")
    }
    println()
    val code3 =0.2
    when(code3){
        0.1 -> println("0.1")
        0.2 -> {
            println("0.2")
            println("비밀번호 입력")
        }
        0.3 -> println("0.3")
        else -> println("값 잘못 입력")
    }
    println()
    val code4 = "a01"
    when(code4){
        "a01" -> println("a01")
        "a02" -> {
            println("a02")
        }
        "a03" -> println("a03")
        else -> println("값 잘못 입력")
    }
    val code5 = 10
    //code 여러 개를 같이 평가
    when(code5){
        in 1..9 -> println("1~9")
        in 10..19 -> {
            println("10~19")
        }
        in 20..29 -> println("20~29")
        else -> println("값 잘못 입력")
    }
    val myresult1 = setValue(90)
    val myresult2 = setValue(80)
    val myresult3 = setValue(70)
    println("myresult1:$myresult1")
    println("myresult2:$myresult2")
    println("myresult3:$myresult3")
}
//
fun setValue(num:Int) = when(num){
    90 -> "합격"
    80 -> "보류"
    70 -> "불합격"
    else -> "키 잘못입력"
}
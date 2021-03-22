import kr.multicampus.kotlin.bank.Account
import java.util.*

fun main(){
    var account:Account = Account("111-222-333",1000000)
    var choice = 0

    val key: Scanner = Scanner(System.`in`)
    while(choice != 4) {
        println("""***********은행시스템************
        |1. 입금하기
        |2. 출금하기
        |3. 잔액조회하기
        |4. 종료
    """.trimMargin())
        println("원하는 작업을 선택하세요:")
        choice = key.nextInt();
        when (choice) {
            1 -> account.deposit()
            2 -> account.withdrawal()
            3 -> account.check()
            4 -> println("종료합니다..")
            else -> println("잘못입력하셨습니다.")
        }
    }
}
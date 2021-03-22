package kr.multicampus.kotlin.basic

fun main(){
    var myarr1= arrayOf(10,10.5,false,'A',"문자열")
    val myarr2 = intArrayOf(10,20,30,40,50)
    //arrayOf<데이터타입> -> Generic
    val myarr3 = arrayOf<String>("python","C","Kotlin","android")

    println("myarr1:$myarr1")
    println("myarr1:${myarr1.contentToString()}")
    println("***************************")
    println("myarr2:$myarr2")
    println("myarr2:${myarr2.contentToString()}")
    println("***************************")
    println("myarr3:$myarr3")
    println("myarr3:${myarr3.contentToString()}")

    //다차원배열
    var arr2D = arrayOf(
                arrayOf(10,20,30,40,50),
                arrayOf(60,70,80,90,100),
                arrayOf(1,2,4,5,10)
    )
    println("***************************")
    println("arr2D:$arr2D")
    println("arr2D:${arr2D.contentToString()}")
    println("arr2D:${arr2D.contentDeepToString()}")
    for(item in arr2D){
        for(i in item){
            print("$i\t")
        }
        println()
        //배열요소 액세스

    }
    println("myarr 0번요소:${myarr2[0]}")
    println("myarr 1번요소:${myarr2[1]}")

    println("myarr 2번요소:${myarr2.get(2)}")
    println("myarr 3번요소:${myarr2.get(3)}")
    println("***********************************")
    myarr2[0] = 1000
    println("myarr2:${myarr2.contentToString()}")
    myarr2.set(1,2000)
    println("myarr2:${myarr2.contentToString()}")

    println("***********************************")
    println("myarr2의 요소의 갯수:${myarr2.size}")
}
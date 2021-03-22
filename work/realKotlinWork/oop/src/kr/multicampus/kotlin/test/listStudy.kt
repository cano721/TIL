package kr.multicampus.kotlin.test

val list1 = mutableListOf<Int>()
val list2 = mutableListOf<String>()

fun main() {
    for (i in 1..10) {
        list1.add(i)
        if(i%2 == 1){
            list2.add("True")
        }
        else{
            list2.add("False")
        }
    }

    println("list1:${list1}")
    println("list2:${list2}")
}


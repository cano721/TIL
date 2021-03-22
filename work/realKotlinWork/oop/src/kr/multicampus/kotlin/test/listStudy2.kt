package kr.multicampus.kotlin.test

fun main(){
    val myarr = intArrayOf(10,20,30,40,50)
    println(listChange(myarr))
    println(mapChange(myarr))
}

fun listChange(myarr: IntArray): MutableList<Int> {
    val list1 = mutableListOf<Int>()
    for(i in myarr){
        list1.add(i)
    }
    return list1
}

fun mapChange(myarr: IntArray): MutableMap<Int,Int> {
    val map1 = mutableMapOf<Int,Int>()
    for(i in myarr){
        map1.put(i+10,i)
    }
    return map1
}
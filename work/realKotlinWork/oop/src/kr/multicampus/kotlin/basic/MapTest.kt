package kr.multicampus.kotlin.basic

fun main(){
    val map1 = mapOf<String,Int>("A01" to 10,"A02" to 20,"A03" to 30)
    println("******************************")
    println("map1:$map1")
    println("******************************")
    val map2 = mutableMapOf<String,String>()
    println("map2:$map2")

    map2.put("id","jang")
    map2.put("pass","1234")
    map2.put("name","장동건")
    map2.put("addr","서울")
    println("map2:$map2")
    println("******************************")
    println("map1:${map1.size}")
    println("map2:${map2.size}")

    println("******************************")
    println("map1:${map1.get("A01")}")
    println("map2:${map2["name"]}")

    println("******************************")
    println("map1:${map1.keys}")
    println("map2:${map2.values}")

    println("******************************")
    println("map1:${map1.containsKey("A01")}")
    println("map1:${map1.containsKey("A05")}")

    println("map2:${map2.containsValue("장동건")}")
    println("map2:${map2.containsValue("장기용")}")

}
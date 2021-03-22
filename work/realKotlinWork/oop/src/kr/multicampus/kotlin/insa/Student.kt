package kr.multicampus.kotlin.insa

class Student(name:String, age:Int, var id:Int):Person(name,age) {

    override fun print(){
        super.print()
        println("학번:$id")
    }
}
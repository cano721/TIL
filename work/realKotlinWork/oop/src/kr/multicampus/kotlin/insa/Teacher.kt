package kr.multicampus.kotlin.insa

class Teacher(name:String, age:Int, var subject:String):Person(name,age) {
    override fun print(){
        super.print()
        println("담당과목:$subject")
    }
}
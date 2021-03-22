package kr.multicampus.kotlin.insa

class Staff(name:String, age:Int, var dept:String):Person(name,age) {
    override fun print(){
        super.print()
        println("부서:$dept")
    }
}
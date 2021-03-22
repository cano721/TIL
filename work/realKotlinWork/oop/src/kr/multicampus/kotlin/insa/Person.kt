package kr.multicampus.kotlin.insa

open class Person(var name:String, var age:Int) {

    open fun print(){
        print("이름:$name,나이:$age")
    }

}
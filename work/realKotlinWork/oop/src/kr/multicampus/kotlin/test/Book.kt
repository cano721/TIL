package kr.multicampus.kotlin.test

class Book (title:String,var year:Int):Content(title) {
    override fun totalPrice() {
        when(year){
           in 1975..1990 -> price = 5000
           in 1991..2000 -> price = 3500
           in 2001..2020 -> price = 1000
           else -> price = 500
        }

    }
}
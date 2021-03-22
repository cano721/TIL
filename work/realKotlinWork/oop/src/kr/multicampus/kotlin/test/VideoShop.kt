package kr.multicampus.kotlin.test

fun main(){
    val myarr = arrayOfNulls<Content>(5)
    myarr[0] = Video("변호인","new")
    myarr[1] = Video("탐정","comic")
    myarr[2] = Video("헬로카봇","child")
    myarr[3] = Book("감자(책)",1982)
    myarr[4] = Book("아두이노마스터",2020)

    for(i in myarr){
        i?.totalPrice()
        i?.show()
    }
}
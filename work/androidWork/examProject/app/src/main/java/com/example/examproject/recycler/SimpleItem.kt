package com.example.fragment.recycler

class SimpleItem {
    var idx:Int = 0
    var date:String = ""
    var id:String = ""
    var ledstate:String = ""

    constructor(date:String, id:String, ledstate:String){
        this.date = date
        this.id = id
        this.ledstate = ledstate
    }
}
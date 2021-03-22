package kr.multicampus.kotlin.test

class Video(title:String,var genre:String):Content(title) {
    override fun totalPrice() {
        if(genre == "new") {
            price = 2000
        }
        else if(genre == "comic"){
                price = 1500
            }
        else if(genre == "child"){
            price = 1000
            }
        else{
            price = 500
        }
        }
    }
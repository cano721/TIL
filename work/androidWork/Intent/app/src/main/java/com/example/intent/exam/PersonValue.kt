package com.example.intent.exam

import android.os.Parcel
import android.os.Parcelable

class PersonValue() :Parcelable{
    var myImg = 0 // 이미지 리소스
    var name:String?=null //이름
    var date:String?=null //날짜
    var checkBox_name:String?=null //체크박스이름

    constructor(parcel: Parcel) : this() {
        myImg = parcel.readInt()
        name = parcel.readString()
        date = parcel.readString()
        checkBox_name = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(myImg)
        parcel.writeString(name)
        parcel.writeString(date)
        parcel.writeString(checkBox_name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PersonValue> {
        override fun createFromParcel(parcel: Parcel): PersonValue {
            return PersonValue(parcel)
        }

        override fun newArray(size: Int): Array<PersonValue?> {
            return arrayOfNulls(size)
        }
    }
}
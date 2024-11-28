package com.example.recycl2

import android.os.Parcel
import android.os.Parcelable
import org.xml.sax.helpers.ParserAdapter

data class DataClass(var titleImage : Int, var heading : String ,var auttxt: String,var genretxt: String):
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(titleImage)
        parcel.writeString(heading)
        parcel.writeString(auttxt)
        parcel.writeString(genretxt)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataClass> {
        override fun createFromParcel(parcel: Parcel): DataClass {
            return DataClass(parcel)
        }

        override fun newArray(size: Int): Array<DataClass?> {
            return arrayOfNulls(size)
        }
    }
}

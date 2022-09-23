package com.example.rojenjohn

import android.os.Parcel
import android.os.Parcelable

//Singular > Planet
data class PlanetDataClass (val imageResourceID: Int?,
                            val title: String?,
                            val galaxy: String?,
                            val link: String?,
                            val distance: Float,
                            val gravity: Float,
                            val overview: String?,
                            val planetResourceID: Int
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readString(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(imageResourceID)
        parcel.writeString(title)
        parcel.writeString(galaxy)
        parcel.writeString(link)
        parcel.writeFloat(distance)
        parcel.writeFloat(gravity)
        parcel.writeString(overview)
        parcel.writeInt(planetResourceID)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PlanetDataClass> {
        override fun createFromParcel(parcel: Parcel): PlanetDataClass {
            return PlanetDataClass(parcel)
        }

        override fun newArray(size: Int): Array<PlanetDataClass?> {
            return arrayOfNulls(size)
        }
    }
}
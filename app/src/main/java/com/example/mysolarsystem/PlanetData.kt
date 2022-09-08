package com.example.mysolarsystem

import android.os.Parcel
import android.os.Parcelable


data class PlanetData(
    val id: Int?,
    val title: String?,
    val galaxy: String?,
    val link: String?,
    val distance: Float,
    val gravity: Float,
    val overview: String?,
    val planetResourceID: Int

    //Parcelable is an Android only Interface used to serialize a class so its properties can be transferred
    //from one activity to another

    //A Parcelable is the Android implementation of the Java Serializable. It assumes a certain structure and way of processing it.
    // This way a Parcelable can be processed relatively fast, compared to the standard Java serialization.

    //Added Parcelable through "Add Parcelable Implementations"

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
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
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

    companion object CREATOR : Parcelable.Creator<PlanetData> {
        override fun createFromParcel(parcel: Parcel): PlanetData {
            return PlanetData(parcel)
        }

        override fun newArray(size: Int): Array<PlanetData?> {
            return arrayOfNulls(size)
        }
    }
}
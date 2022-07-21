package com.example.ksbaodemo.data
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName

@Parcelize
@Serializable
data class Child(
    @SerialName("AppNum")
    val appNum: Int,
    @SerialName("CName")
    val cName: String,
    @SerialName("Childs")
    val childs: List<Child>?,
    @SerialName("IsMedi")
    val isMedi: Int,
    @SerialName("KsbClassID")
    val ksbClassID: Int,
    @SerialName("KsbClassName")
    val ksbClassName: String,
    @SerialName("MediClassID")
    val mediClassID: Int,
    @SerialName("PID")
    val pID: Int,
    @SerialName("SName")
    val sName: String
) : Parcelable
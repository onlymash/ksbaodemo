package com.example.ksbaodemo.data
import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName

@Serializable
data class Medata(
    @SerialName("Button")
    val button: Int,
    @SerialName("Colour")
    val colour: String,
    @SerialName("IconUrl")
    val iconUrl: String,
    @SerialName("MediClassID")
    val mediClassID: Int,
    @SerialName("Remark")
    val remark: String?,
    @SerialName("SortID")
    val sortID: Int,
    @SerialName("Title")
    val title: String,
    @SerialName("WordColour")
    val wordColour: String
)
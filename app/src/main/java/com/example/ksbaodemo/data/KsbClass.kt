package com.example.ksbaodemo.data
import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName


@Serializable
data class KsbClass(
    @SerialName("data")
    val `data`: List<Child>,
    @SerialName("medata")
    val medata: List<Medata>,
    @SerialName("msg")
    val msg: String,
    @SerialName("status")
    val status: Int
)

package com.example.consumeapi.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Kontak(
    val id: Int,
    @SerialName(value = "nama")
    val nama: String,
    @SerialName(value = "email")
    val email: String,
    @SerialName(value = "no_hp")
    val nohp: String,
)
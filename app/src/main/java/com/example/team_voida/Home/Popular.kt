package com.example.team_voida.Home

import kotlinx.serialization.Serializable

@Serializable
data class Popular(
    val img: String,
    val rank: String,
    val name: String,
    val price: String,
    val discount: String
)

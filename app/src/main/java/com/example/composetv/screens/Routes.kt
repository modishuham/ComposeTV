package com.example.composetv.screens

import kotlinx.serialization.Serializable

@Serializable
object HomeScreenRoute

@Serializable
data class DetailScreenRoute(
    val name: String?,
    val image: String?
)
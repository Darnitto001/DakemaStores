package com.darnitto.dakemastores.model


data class Category(
    val title: String,
    val iconRes: Int, // Reference to drawable resource
    val onClick: () -> Unit,
)


package com.darnitto.dakemastores.model

data class Order(
    val id: Int = 0,
    val totalAmount: Double,
    val status: String = "Pending", // e.g., "Pending", "Shipped", "Delivered"
    val customerName: String,
    val customerPhone: String,
    val address: String,
    val timestamp: Long = System.currentTimeMillis()
)

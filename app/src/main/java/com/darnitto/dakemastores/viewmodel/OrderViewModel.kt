package com.darnitto.dakemastores.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.darnitto.dakemastores.model.Order

class OrderViewModel : ViewModel() {

    private val _orders = MutableLiveData<List<Order>>(emptyList())
    val orders: LiveData<List<Order>> = _orders

    fun placeOrder(order: Order) {
        val currentOrders = _orders.value?.toMutableList() ?: mutableListOf()
        currentOrders.add(order)
        _orders.value = currentOrders
    }

    fun updateOrderStatus(orderId: Int, newStatus: String) {
        val updatedOrders = _orders.value?.map {
            if (it.id == orderId) it.copy(status = newStatus) else it
        }
        _orders.value = updatedOrders
    }

    fun getOrderById(orderId: Int): Order? {
        return _orders.value?.find { it.id == orderId }
    }
}

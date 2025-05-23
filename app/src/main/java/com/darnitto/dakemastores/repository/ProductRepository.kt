package com.darnitto.dakemastores.repository

import android.content.Context
import com.darnitto.dakemastores.data.ProductDatabase
import com.darnitto.dakemastores.model.Product

class ProductRepository(context: Context) {
    private val productDao = ProductDatabase.getDatabase(context).productDao()

    suspend fun insertProduct(product: Product) {
        productDao.insertProduct(product)
    }

    fun getAllProducts() = productDao.getAllProducts()

    suspend fun deleteProduct(product: Product) = productDao.deleteProduct(product)
}
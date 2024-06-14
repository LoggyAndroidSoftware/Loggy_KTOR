package com.loggy.domains.inventory.interfaces.commands

import com.loggy.domains.inventory.models.Product

interface ProductCommandDAO {

    suspend fun addNewProduct(name: String, brandId: Int, image: String): Product?
    suspend fun editProduct(id: Int, name: String, brandId: Int, image: String): Boolean
    suspend fun deleteProduct(id: Int): Boolean
}

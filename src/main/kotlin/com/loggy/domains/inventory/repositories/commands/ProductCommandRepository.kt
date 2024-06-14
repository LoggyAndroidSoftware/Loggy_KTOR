package com.loggy.domains.inventory.repositories.commands

import com.loggy.domains.inventory.interfaces.commands.ProductCommandDAO
import com.loggy.domains.inventory.models.Product

object ProductCommandRepository : ProductCommandDAO {

    private val products = mutableListOf<Product>()
    override suspend fun addNewProduct(name: String, brandId: Int, image: String): Product? {
        if (name == null || brandId == null || image == null) {
            throw IllegalArgumentException("Los parámetros no pueden ser nulos")
        }
        val newProduct = Product(products.size + 1, name, brandId, image)
        if (products.add(newProduct) != null){
            return newProduct
        }
        else {
            throw IllegalStateException("Failed to add new product")
        }
    }

    override suspend fun editProduct(id: Int, name: String, brandId: Int, image: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteProduct(id: Int): Boolean {
        TODO("Not yet implemented")
    }


}
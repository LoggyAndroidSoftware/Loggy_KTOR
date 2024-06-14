package com.loggy.domains.inventory.repositories.queries

import com.loggy.domains.inventory.interfaces.queries.ProductQueryDAO
import com.loggy.domains.inventory.models.Product

object ProductQueryRepository : ProductQueryDAO{

    override suspend fun allProducts(): List<Product> {
        TODO("Not yet implemented")
    }

    override suspend fun filterProductsByBrand(brandId: Int): List<Product> {
        TODO("Not yet implemented")
    }

    override suspend fun filterProductsByCategory(categoryId: Int): List<Product> {
        TODO("Not yet implemented")
    }

    override suspend fun filterProductsByPrice(price: Double): List<Product> {
        TODO("Not yet implemented")
    }

    override suspend fun filterProductsByRating(rating: Double): List<Product> {
        TODO("Not yet implemented")
    }
}
package com.loggy.domains.inventory.interfaces.queries

import com.loggy.domains.inventory.models.Product

interface ProductQueryDAO{
    suspend fun allProducts(): List<Product>
    suspend fun filterProductsByBrand(brandId: Int): List<Product>
    suspend fun filterProductsByCategory(categoryId: Int): List<Product>
    suspend fun filterProductsByPrice(price: Double): List<Product>
    suspend fun filterProductsByRating(rating: Double): List<Product>
}

package com.loggy

import com.loggy.domains.inventory.models.Brand
import org.jetbrains.exposed.sql.statements.api.ExposedBlob

interface DAOFacade{
    suspend fun allBrands(): List<Brand>
    suspend fun getBrandById(id: Int): Brand?
    suspend fun addNewBrand(name: String, description: String, image: String): Brand?
    suspend fun editBrand(id: Int, name: String, description: String, image: String): Boolean
    suspend fun deleteBrand(id: Int): Boolean
}
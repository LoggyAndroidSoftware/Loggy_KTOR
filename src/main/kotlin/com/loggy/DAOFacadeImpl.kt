package com.loggy

import com.loggy.DatabaseSingleton.dbQuery
import com.loggy.domains.inventory.models.Brand
import com.loggy.domains.inventory.models.Brands
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.statements.api.ExposedBlob

class DAOFacadeImpl : DAOFacade {
    private fun resultRowToBrand(row: ResultRow): Brand {
        return Brand(
            brandId = row[Brands.brandId],
            brandName = row[Brands.brandName],
            brandDescription = row[Brands.brandDescription],
            brandImage = row[Brands.brandImage]
        )
    }
    override suspend fun allBrands(): List<Brand> = dbQuery {
        Brands.selectAll().map (::resultRowToBrand )
    }

    override suspend fun getBrandById(id: Int): Brand? = dbQuery {
        Brands
            .select { Brands.brandId eq id }
            .map (::resultRowToBrand)
            .singleOrNull()
    }

    override suspend fun addNewBrand(name: String, description: String, image: String): Brand? = dbQuery {
        val insertBrand = Brands.insert {
            it[Brands.brandName] = name
            it[Brands.brandDescription] = description
            it[Brands.brandImage] = image
        }
        insertBrand.resultedValues?.singleOrNull()?.let(::resultRowToBrand)
    }

    override suspend fun editBrand(id: Int, name: String, description: String, image: String): Boolean = dbQuery{
        Brands.update({ Brands.brandId eq id }) {
            it[Brands.brandName] = name
            it[Brands.brandDescription] = description
            it[Brands.brandImage] = image
        } > 0
    }

    override suspend fun deleteBrand(id: Int): Boolean = dbQuery{
        Brands.deleteWhere { Brands.brandId eq  id } > 0
    }


}

val dao: DAOFacade = DAOFacadeImpl().apply {
    runBlocking {
        if(allBrands().isEmpty()) {
            addNewBrand("Brand1", "Brand1 Description", "image.jpg")
        }
    }
}
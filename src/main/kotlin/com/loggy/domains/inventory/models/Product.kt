package com.loggy.domains.inventory.models

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.statements.api.ExposedBlob
import java.util.*

data class Product(
    var productId: Int,
    var productCodename: String,
    var productBrand: Int,
    var productImage: String,
)
/*
{
    companion object {
        private var lastId = 0
    }

    init {
        productId = ++lastId
    }

}
*/
object Products: Table(){
    val productId = integer("product_id").autoIncrement()
    val productCodename = varchar("product_codename", 50)
    val productBrand = reference("product_brand", Brands.brandId, ReferenceOption.CASCADE)
    val productImage = varchar("product_image", 255)

    override val primaryKey = PrimaryKey(productId)
}


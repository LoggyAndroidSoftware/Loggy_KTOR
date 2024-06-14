package com.loggy.domains.inventory.models


import org.jetbrains.exposed.sql.*


data class Brand(
    val brandId: Int,
    val brandName: String,
    val brandDescription: String,
    val brandImage: String
)

object Brands: Table(){
    val brandId = integer("brand_id").autoIncrement()
    val brandName = varchar("brand_name", 50)
    val brandDescription = varchar("brand_description", 255)
    val brandImage = varchar("brand_image", 255)

    override val primaryKey = PrimaryKey(brandId)
}
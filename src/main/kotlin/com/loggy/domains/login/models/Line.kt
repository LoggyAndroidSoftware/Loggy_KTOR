package com.loggy.domains.login.models

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.statements.api.ExposedBlob
data class Line(
    val lineId: Int,
    val lineName: String,
    val lineCategory : String,
    val lineImage: ExposedBlob
)

object Lines: Table(){
    val lineId = integer("line_id").autoIncrement()
    val lineName = varchar("line_name", 50)
    val lineCategory = varchar("line_category", 50)
    val lineImage = blob("line_image")

    override val primaryKey = PrimaryKey(lineId)
}
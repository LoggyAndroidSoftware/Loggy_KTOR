package com.loggy.routes

import com.loggy.domains.inventory.models.Product
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.statements.api.ExposedBlob

fun Route.productRouting(){
    route("/product") {
        get {
            val products = listOf(
                Product(1, "product1", 1, "image1.jpeg"),
                Product(2, "product2", 2, "image2.jpeg"),
                )
            call.respond(products)
        }
    }
}
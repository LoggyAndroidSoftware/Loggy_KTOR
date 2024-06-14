package com.loggy.plugins

import com.loggy.routes.brandRouting
import com.loggy.routes.productRouting

import io.ktor.server.application.*

import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        productRouting()
        brandRouting()
    }
}

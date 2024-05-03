package com.loggy

import com.loggy.plugins.*
import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*


fun main() {
    embeddedServer(Netty, port = 8080,
        host = "127.0.0.1",
        module = Application::module)
            .start(wait = true)
}

fun Application.module() {


    configureSerialization()
    configureRouting()
}

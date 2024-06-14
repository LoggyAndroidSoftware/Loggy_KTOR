package com.loggy.routes


import com.loggy.domains.login.models.User
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

/*
private val users = mutableListOf(
    User(0, "Diego", "Sánchez","die-san", "die.san@enterprise.com", "d3v3l0per", "70045040"),
    User(0, "Developer", "UPC","developer.moviles", "developer.moviles@enterprise.com", "d3v3l0p3r", "70045041"),

)

fun Route.userRouting() {
    route("/user") {
        get {
            if (users.isNotEmpty()) {
                call.respond(users)
            } else {
                call.respondText("No users found", status = HttpStatusCode.NotFound)
            }

        }
        get("{id?}") {
            val id = call.parameters["id"]?.toIntOrNull()
            if (id != null) {
                val user = users.find { it.id == id }
                if (user != null) {
                    call.respond(user)
                } else {
                    call.respondText("No user with id $id", status = HttpStatusCode.NotFound)
                }
            } else {
                call.respondText("Invalid id", status = HttpStatusCode.BadRequest)
            }
        }
        post {
            val user = call.receive<User>()
            users.add(user)
            call.respondText("El usuario se ha guardado correctamente", status = HttpStatusCode.Created)

        }
        delete("{id?}") {
            val id = call.parameters["id"]?.toIntOrNull()
            if (id != null) {
                if (users.removeIf { it.id == id }) {
                    call.respondText("El usuario se ha eliminado correctamente")
                } else {
                    call.respondText("No hay ningun usuario con el id: $id", status = HttpStatusCode.NotFound)
                }
            } else {
                call.respondText("Invalid id", status = HttpStatusCode.BadRequest)
            }
        }
    }
}
*/
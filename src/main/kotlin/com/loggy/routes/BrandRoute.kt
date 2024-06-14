package com.loggy.routes


import com.loggy.dao
import com.loggy.domains.inventory.models.Brand
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*
import org.jetbrains.exposed.sql.statements.api.ExposedBlob


fun Route.brandRouting() {
    route("/brand") {
        get {
            call.respond(FreeMarkerContent("index.ftl", mapOf("brands" to dao.allBrands())))
        }
        get("{id}") {
            val id = call.parameters.getOrFail<Int>("id").toInt()
            call.respond(FreeMarkerContent("show.ftl", mapOf("brand" to dao.getBrandById(id))))
        }
        /*
        post {
            val formParameters = call.receiveParameters()
            val name = formParameters.getOrFail("brand_name")
            val description = formParameters.getOrFail("brand_description")
            val image = formParameters.getOrFail("brand_image")
            val brand = dao.addNewBrand(name, description, image)


        }

        */


    }
}




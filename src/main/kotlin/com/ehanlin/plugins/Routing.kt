package com.ehanlin.plugins

import com.ehanlin.model.listUniformInvoiceRoute
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        listUniformInvoiceRoute()
    }
}

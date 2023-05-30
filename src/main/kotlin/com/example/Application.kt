package com.example

import com.example.plugins.configureRouting
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(CIO, port = 8080) { //}), host = "0.0.0.0", module = Application::module)
        routing {
            get("/") {
                call.respondText("OK")
            }
        }
    }.start(wait = true)
    println("open http://localhost:8080")
}

fun Application.module() {
    configureRouting()
}

package com.example

import com.example.plugins.configureRouting
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.plugins.contentnegotiation.*

fun main() {
    embeddedServer(CIO, port = 8080) { //}), host = "0.0.0.0", module = Application::module)
        install(ContentNegotiation) {
            json()
        }
        routing {
            get("/") {
                call.respondText("OK")
            }
            get("/status") {
                call.respond(mapOf("status" to "OK"))
            }
        }
    }.start(wait = true)
    println("open http://localhost:8080")
}

fun Application.module() {
    configureRouting()
}

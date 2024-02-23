package practice.websocket

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication

class WebSocketClientApplication {
}

fun main(args: Array<String>) {
    runApplication<WebSocketClientApplication>(*args)
}


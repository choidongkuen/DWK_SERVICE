package delivery

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DeliveryServerApplication

fun main(args: Array<String>) {
    runApplication<DeliveryServerApplication>(*args)
}

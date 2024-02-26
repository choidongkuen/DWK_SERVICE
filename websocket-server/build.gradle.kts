plugins {
    id("org.jlleitschuh.gradle.ktlint") version "12.1.0"
}

group = "practice.websocket"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-websocket")
}

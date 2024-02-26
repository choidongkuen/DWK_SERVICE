pluginManagement {
    plugins {
        id("io.spring.dependency-management") version "1.1.4"
        id("org.springframework.boot") version "3.2.2"
        kotlin("jvm") version "1.9.22"
        kotlin("plugin.spring") version "1.9.22"
        id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
    }
}
rootProject.name = "websocket"
include("websocket-client")
include("websocket-server")
include("delivery-server")

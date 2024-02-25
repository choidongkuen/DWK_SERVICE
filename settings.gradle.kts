plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "websocket"
include("websocket-client")
include("websocket-server")
include("delivery-server")

plugins {
    id("org.jlleitschuh.gradle.ktlint") version "12.1.0"
}

group = "org.delivery"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.mysql:mysql-connector-j")
    // flyway
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-mysql")
    // swagger
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
}

kotlin {
    jvmToolchain(17)
}

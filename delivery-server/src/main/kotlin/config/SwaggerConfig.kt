package config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import org.springframework.context.annotation.Configuration


@OpenAPIDefinition(
    info = io.swagger.v3.oas.annotations.info.Info(
        title = "배달 서비스 API",
        description = "배달 서비스 API 문서이빈다.",
        version = "0.1"
    )
)
@Configuration
class SwaggerConfig {
}

package com.ecommerce.msuserservice.config;

import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean; import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean GroupedOpenApi api() {
        return GroupedOpenApi.builder().group("user-service").pathsToMatch("/api/**").build();
    }
    @Bean io.swagger.v3.oas.models.OpenAPI openAPI() {
        return new io.swagger.v3.oas.models.OpenAPI().info(new Info().title("User Service").version("v1"));
    }
}
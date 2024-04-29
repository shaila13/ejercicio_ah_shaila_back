package com.shaila.ejercicio.infraestructure.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Price App", version = "1.0", description = "App for querying the final price of a product."))
public class OpenApiConfig {
}

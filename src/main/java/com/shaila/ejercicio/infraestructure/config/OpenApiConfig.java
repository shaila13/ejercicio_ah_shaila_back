package com.shaila.ejercicio.infraestructure.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "App precios", version = "1.0", description = "App de consulta del precio final de un producto"))
public class OpenApiConfig {
}

package com.TicketsPrueba.LuisZuluaga.infrastructure.config;

import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi apiGroup() {
        return GroupedOpenApi.builder()
                .group("tickets-api")
                .pathsToMatch("/api/**")
                .build();
    }

    @Bean
    public Info apiInfo() {
        return new Info().title("API de Tickets")
                .description("Esta es la documentación de la API de gestión de tickets.")
                .version("1.0.0");
    }
}

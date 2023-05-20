package com.koshkarov.student_group.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info().title("Микросервис по формированию расписания для студентов и преподавателей")
                        .description("REST API групп, студентов, преподавателей, уроков")
                        .version("1.0"));
    }
}
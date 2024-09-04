package io.ooruda.allclimb.user.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .version("0.0.1")
                        .title("All Climb User API")
                        .description("All Climb User API-Docs")
                );
    }
}
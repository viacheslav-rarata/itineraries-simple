package org.challenge.adidas.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger configuration
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        ApiInfo DEFAULT_API_INFO = new ApiInfoBuilder()
                .description("Endpoints for data access.")
                .title("Itineraries consumer service")
                .version("1.0-SNAPSHOT").build();

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.challenge.adidas.consumer"))
                .paths(PathSelectors.any())
                .build();
    }
}

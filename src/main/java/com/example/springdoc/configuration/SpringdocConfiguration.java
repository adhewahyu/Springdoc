package com.example.springdoc.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(servers = {
        @Server(url = "/", description = "Local Access"),
        @Server(url = "${swagger.contextPath}", description = "Reverse Proxy Access")
})
public class SpringdocConfiguration {

    private static final String BASE_PACKAGE = "com.example.springdoc.controller";

    private static final String[] HELLO_APIS = {
            "/hello/v1/greeting"
    };

    @Bean
    public OpenAPI baseSpringdoc() {
        return new OpenAPI()
                .info(new Info()
                        .title("Testing Spring Docs")
                        .description("This is description")
                        .version("v0.1")
                        .termsOfService("https://swagger.io/terms/")
                        .contact(new io.swagger.v3.oas.models.info.Contact().name("Adhe Wahyu A.").url("").email("adhe.wahyu.ardanto@gmail.com"))
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")));
    }

    @Bean
    public GroupedOpenApi allApis(){
        return GroupedOpenApi.builder()
                .group("All APIs Recipe")
                .displayName("All APIs Recipe")
                .packagesToScan(BASE_PACKAGE)
                .pathsToExclude("/swagger-ui/swagger-ui.css")
                .build();
    }

    @Bean
    public GroupedOpenApi helloApis(){
        return GroupedOpenApi.builder()
                .group("Hello Recipe")
                .displayName("Hello Recipe")
                .packagesToScan(BASE_PACKAGE)
                .pathsToMatch(HELLO_APIS)
                .build();
    }

}

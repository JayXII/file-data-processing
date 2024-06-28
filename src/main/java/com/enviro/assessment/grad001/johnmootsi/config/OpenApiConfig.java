//package com.enviro.assessment.grad001.johnmootsi.config;
//
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.parser.OpenAPIV3Parser;
//import io.swagger.v3.parser.core.models.SwaggerParseResult;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.IOException;
//import java.io.InputStream;
//
//@Configuration
//public class OpenApiConfig {
//
//    @Bean
//    public OpenAPI customOpenAPI() throws IOException {
//        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("openapi.yaml");
//        if (inputStream == null) {
//            throw new RuntimeException("Could not find openapi.yaml on the classpath");
//        }
//        SwaggerParseResult parseResult = new OpenAPIV3Parser().readContents(new String(inputStream.readAllBytes()), null, null);
//        OpenAPI openAPI = parseResult.getOpenAPI();
//        if (openAPI == null) {
//            openAPI = new OpenAPI();
//        }
//        return openAPI;
//    }
//}
//
//

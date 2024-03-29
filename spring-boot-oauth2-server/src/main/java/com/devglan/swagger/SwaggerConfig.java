package com.devglan.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {

        ParameterBuilder aParameterBuilder = new ParameterBuilder();
        aParameterBuilder
                .name("SYY-Correlation-ID")
                .modelRef(
                        new ModelRef("string")
                )
                .parameterType("header")
                .required(false)
                .description("Correlation ID")
                .build();

        List<Parameter> aParameters = new ArrayList<>();
        aParameters.add(aParameterBuilder.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.devglan.controller"))
                .build().apiInfo(apiInfo())
                .globalOperationParameters(aParameters);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Shopping - Item Purchase API",
                "Item Purchase Service",
                "1.0",
                "Terms and Condition URL",
                new Contact("Sysco Labs", "", ""),
                "License",
                "License URL");
    }
}

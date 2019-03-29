package com.springboot.demo.common.config;

import com.google.common.base.Predicate;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestOpenApi() {

        Predicate<RequestHandler> predicate = input -> {
            //只有添加了ApiOperation注解的method才在API中显示
            if (input.isAnnotatedWith(ApiOperation.class)) {
                return true;
            }
            return false;
        };

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(openApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.springboot.demo.sys.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo openApiInfo() {
        return new ApiInfoBuilder()
                .title("demo RESTful APIs")
                .description("")
                .version("1.0")
                .build();
    }

}

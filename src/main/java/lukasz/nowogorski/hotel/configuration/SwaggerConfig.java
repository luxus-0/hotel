package lukasz.nowogorski.hotel.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("lukasz.nowogorski.hotel.api"))
                .paths(PathSelectors.any())
                .build();


    }

    @Bean
    UiConfiguration uiConfig() {
        return UiConfigurationBuilder
                .builder()
                .tagsSorter(TagsSorter.ALPHA)
                .operationsSorter(OperationsSorter.METHOD)
                .operationsSorter(OperationsSorter.ALPHA)
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("HOTEL API",
                "HOTEL DOCUMENTATION",
                "4.00",
                "https://github.com/luxus-0/hotel",
                new Contact("Lukasz Nowogórski", "https://github.com/luxus-0/hotel", "nowogorski.lukasz0@gmail.com"),
                "",
                "",
                Collections.emptyList()
        );
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}

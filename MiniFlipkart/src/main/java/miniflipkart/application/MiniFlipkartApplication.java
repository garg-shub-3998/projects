package miniflipkart.application;

import miniflipkart.application.filter.AuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;


@SpringBootApplication
@EnableSwagger2
public class MiniFlipkartApplication {

    @Autowired
    private AuthorizationFilter authorizationFilter;


    private Parameter authHeader = new ParameterBuilder()
            .parameterType("header")
            .name("Auth")
            .modelRef(new ModelRef("string"))
            .build();


    private ApiInfo apiDetails() {
        return new ApiInfoBuilder()
                .title("My Api Documentation")
                .description("Desc for my apis")
                .license(null)
                .version("1.0")
                .build();
    }


    public static void main(String[] args) {
        SpringApplication.run(MiniFlipkartApplication.class, args);
    }

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/**"))
                .apis(RequestHandlerSelectors.basePackage("miniflipkart.application"))
                .build()
                .apiInfo(apiDetails())
                .globalOperationParameters(Collections.singletonList(authHeader));


    }

    @Bean
    FilterRegistrationBean authorizationFilterRegistration() {
        FilterRegistrationBean authorizationFilterBean = new FilterRegistrationBean();
        authorizationFilterBean.setFilter(authorizationFilter);
        authorizationFilterBean.setUrlPatterns(Arrays.asList("/api/*"));
        return authorizationFilterBean;
    }


}

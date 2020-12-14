package SpringBoot.MiniFlipkart;

import SpringBoot.MiniFlipkart.application.config.filter.AdminFilter;
import SpringBoot.MiniFlipkart.application.config.filter.CustomerFilter;
import SpringBoot.MiniFlipkart.application.config.filter.VendorFilter;
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
    private AdminFilter adminFilter;

    @Autowired
    private VendorFilter vendorFilter;

    @Autowired
    private CustomerFilter customerFilter;


    public static void main(String[] args) {
        SpringApplication.run(MiniFlipkartApplication.class, args);
    }


    Parameter authHeader = new ParameterBuilder()
            .parameterType("header")
            .name("Auth")
            .modelRef(new ModelRef("string"))
            .build();

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/**"))
                .apis(RequestHandlerSelectors.basePackage("SpringBoot.MiniFlipkart"))
                .build()
                .apiInfo(apiDetails())
                .globalOperationParameters(Collections.singletonList(authHeader));



    }

    private ApiInfo apiDetails() {
        return new ApiInfoBuilder()
                .title("My Api Documentation")
                .description("Desc for my apis")
                .license(null)
                .version("1.0")
                .build();
    }

     @Bean
     FilterRegistrationBean CustomerFilterRegistration() {
        FilterRegistrationBean frb1 = new FilterRegistrationBean();
        frb1.setFilter( customerFilter);
        frb1.setUrlPatterns(Arrays.asList("/api/customer/*"
                , "/api/cart/*", "/api/order/*"));
        return frb1;
    }

    @Bean
    FilterRegistrationBean VendorRegistration() {
        FilterRegistrationBean frb2 = new FilterRegistrationBean();
        frb2.setFilter( vendorFilter);
        frb2.setUrlPatterns(Arrays.asList("/api/vendor/*"));
        return frb2;
    }

    @Bean
    FilterRegistrationBean AdminRegistration() {
        FilterRegistrationBean frb3 = new FilterRegistrationBean();
        frb3.setFilter(adminFilter);
        frb3.setUrlPatterns(Arrays.asList("/api/admin/*"));
        return frb3;
    }



}

package b101.percast.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket restAPI(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any()) // 대상 패키
                .paths(PathSelectors.any()) // 어떤 식으로 시작하는 api를 보여줄 것인지
                .build();
    }
//    private ApiInfo apiInfo(){
//        return new ApiInfoBuilder()
//                .title("percast Spring Boot REST API")
//                .version("1.0.0")
//                .description("특화 B101 swagger api입니다.")
//                .build();
//    }
}

package com.example.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 // swagger2 버전을 활성화 하겠다는 어노테이션
public class SwaggerConfig {

    @Bean
    public Docket restAPI() { // swagger 설정의 핵심이 되는 bean
        return new Docket(DocumentationType.SWAGGER_2)
                //.useDefaultResponseMessages(false) = false로 설정하면 swagger에서 제공해주는 응답코드 (200, 401, 403, 404)에 대한 기본 메세지를 제거해준다.
                .apiInfo(apiInfo())// 제목,설명 등 문서에 대한 정보들을 설정하기 위해 호출
                .select()// ApiSelectorBuilder를 생성하여 apis()와 paths()를 사용할 수 있게 해준다.
                .apis(RequestHandlerSelectors.basePackage("com.example"))// api 스펙이 작성되어 있는 패키지를 지정한다.
                .paths(PathSelectors.any())// apis()로 선택되어진 API중 특정 path 조건에 맞는 API를 다시 필터링하여 문서화 한다, PathSelector.any()로 설정하면 패키지 안에 모든 API를 한번에 볼수 있다.
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("example Spring Boot REST API")
                .version("1.0.0")
                .description(" swagger api 입니다.")
                .build();
    }
}

package demo;

import com.google.common.base.Predicate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.AuthorizationScopeBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static com.google.common.base.Predicates.or;
import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2 //Enable swagger 2.0 spec
public class SwaggerConfig {
  @Bean
   public Docket customImplementation(){
      return new Docket(DocumentationType.SWAGGER_2)
        //.groupName("greeting-api-group")
        .apiInfo(apiInfo())
        .select()
        .paths(petstorePaths())
        .build();
   }

   private ApiInfo apiInfo() {
       return new ApiInfoBuilder()
               .title("Springfox petstore API")
               .description("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum " +
                       "has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a " +
                       "galley of type and scrambled it to make a type specimen book. It has survived not only five " +
                       "centuries, but also the leap into electronic typesetting, remaining essentially unchanged. " +
                       "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum " +
                       "passages, and more recently with desktop publishing software like Aldus PageMaker including " +
                       "versions of Lorem Ipsum.")
               .termsOfServiceUrl("http://springfox.io")
               .contact("springfox")
               .license("Apache License Version 2.0")
               .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
               .version("2.0")
               .build();
   }

   private Predicate<String> petstorePaths() {
       return or(
               regex("/api/.*"),
               regex("/greetings.*"),
               regex("/greetings/.*")
       );
   }
   /*
    @Bean
    public Docket petApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("full-petstore-api")
                .apiInfo(apiInfo())
                .select()
                .paths(petstorePaths())
                .build();
    }

    @Bean
    public Docket userApi() {
        AuthorizationScope[] authScopes = new AuthorizationScope[1];
        authScopes[0] = new AuthorizationScopeBuilder()
                .scope("read")
                .description("read access")
                .build();
        SecurityReference securityReference = SecurityReference.builder()
                .reference("test")
                .scopes(authScopes)
                .build();

        ArrayList<SecurityContext> securityContexts = newArrayList(SecurityContext.builder().securityReferences(newArrayList(securityReference)).build());
        return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(newArrayList(new BasicAuth("test")))
                .securityContexts(securityContexts)
                .groupName("user-api")
                .apiInfo(apiInfo())
                .select()
                .paths(userOnlyEndpoints())
                .build();
    }



    private Predicate<String> userOnlyEndpoints() {
        return new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return input.contains("user");
            }
        };
    }
*/
}

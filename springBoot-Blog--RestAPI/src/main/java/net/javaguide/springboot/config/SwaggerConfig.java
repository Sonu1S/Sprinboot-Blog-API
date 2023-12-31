package net.javaguide.springboot.config;
//package java.com.myblog.blogapp.config;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.ApiKey;
//import springfox.documentation.service.AuthorizationScope;
//import springfox.documentation.service.Contact;
//import springfox.documentation.service.SecurityReference;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.contexts.SecurityContext;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
////@EnableSwagger2
//public class SwaggerConfig {
//
//	public static final String AUTHORIZATION_HEADER = "Authorization";
//	 private ApiKey apiKey() {
//		 return new ApiKey("JWT",AUTHORIZATION_HEADER,"header");
//	 }
//	
//	@Bean
//	  public Docket api() {
//	    return new Docket(DocumentationType.SWAGGER_2)
//	        .apiInfo(apiInfo())
//	        .securityContexts(Arrays.asList(securityContext()))
//	        .securitySchemes(Arrays.asList(apiKey()))
//	        .select()
//	        .apis(RequestHandlerSelectors.any()) // Replace with your base package
//	        .paths(PathSelectors.any())
//	        .build();
//	  }
//	  
//	  private ApiInfo apiInfo() {
//	    return new ApiInfo(
//	        ("Spring boot blog rest API"),
//	        ("Description of your API"),
//	        ("1.0.0"),
//	        "Terms of service",
//	        new Contact("sonu","www.javaguides.net","sonu@gmail.com"),
//	        "License of API","API License URL",
//	        Collections.emptyList()
//	        
//	    		);
//	  }
//	  
//	  private SecurityContext securityContext() {
//		return SecurityContext.builder().securityReferences(defaultAuth()).build();
//		  
//	  }
//	  private List<SecurityReference> defaultAuth(){
//		  AuthorizationScope  authorizationscope = new  AuthorizationScope("global","accessEverything");
//		  AuthorizationScope[]  authorizationscopes =new AuthorizationScope[1];
//		  authorizationscopes[0] = authorizationscope;
//		  
//		  return Arrays.asList(new SecurityReference("JWT", authorizationscopes));
//		  
//	  }
//}
//

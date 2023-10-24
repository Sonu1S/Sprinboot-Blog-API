package net.javaguide.springboot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info  //it is a general information about swagger
		(
			title ="Spring boot Blog App RestAPI Documentation",
			description = "Welcome to the API documentation for the Spring Boot Blog App. This documentation "
					+ "provides detailed information about the available endpoints, request and response formats, "
					+ "and other important aspects of the API.",
			version="v1.0",
			contact=@Contact
			(
					name="Sonu Sharma",
					email="sonukrsharma1298@gmail.com",
					url="https://javaguides.net"
			),
			license = @License
			(
					name ="Apache 2.0",
					url = "https://javaguides.net/license"
			)
		),	
		externalDocs = @ExternalDocumentation( //it is a external documentaion details
				description = "For more information about the Spring Boot Blog App and its development, "
						+ "please visit our official documentation.",
				url="https://github.com/Sonu1S/swagger-API/tree/master/springBoot-Blog--RestAPI"
				)
		)



public class SpringBootBlogRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBlogRestApiApplication.class, args);
           System.out.println("Sonu");
	}
	
	@Bean
    public ModelMapper modelMapper() {
    	return new ModelMapper();
    }
}

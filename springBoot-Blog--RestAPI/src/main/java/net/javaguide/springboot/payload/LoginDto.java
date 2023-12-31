package net.javaguide.springboot.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema( //We are providing User Dto model information
		description = "LogInDto Model Information"
		)
public class LoginDto {
   
	 @Schema( //We are providing User Dto model information
				description = "LogIn With email"
				)
	private String usernameOrEmail;
	 
	 @Schema( //We are providing User Dto model information
				description = "LogIn With password"
				)
	private String password;
	
	
	public LoginDto() {
		super();
	}
	public LoginDto(String usernameOrEmail, String password) {
		super();
		this.usernameOrEmail = usernameOrEmail;
		this.password = password;
	}
	  
	public String getUsernameOrEmail() {
		return usernameOrEmail;
	}
	public void setUsernameEmail(String usernameEmail) {
		this.usernameOrEmail = usernameEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

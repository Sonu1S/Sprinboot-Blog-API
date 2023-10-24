package net.javaguide.springboot.payload;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema( //We are providing User Dto model information
		description = "SignUpDto Model Information"
		)
public class SignUpDto {
	
	 @Schema( //We are providing User Dto model information
				description = "signUp With name"
				)
    private String name;
	 
	 @Schema( //We are providing User Dto model information
				description = "signUp With username"
				)
    private String username;
	 
	 @Schema( //We are providing User Dto model information
				description = "signUp With email "
				)
    private String email;
	 
	 @Schema( //We are providing User Dto model information
				description = "signUp With password"
				)
    private String password;
	
    
    public SignUpDto() {
		super();
	}
    
	public SignUpDto(String name, String username, String email, String password) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    
}

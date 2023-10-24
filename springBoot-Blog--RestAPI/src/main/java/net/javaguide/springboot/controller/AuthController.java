package net.javaguide.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.javaguide.springboot.payload.JWTAuthResponse;
import net.javaguide.springboot.payload.LoginDto;
import net.javaguide.springboot.payload.SignUpDto;
import net.javaguide.springboot.service.AuthService;

@Tag(

	name = "Authentication Controller",
	description = "Authentication Controller - Handles user authentication and authorization processes."
		)

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
	private AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	
	@Operation( //its for custamize documentaion
				summary = "User Login API",
				description = "The User Login API allows registered users to authenticate and obtain"
						+ " access to the application."
		)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP Status 201 CREATED - Successful login."
		)

	//build login api
    @PostMapping({"/login","/signin"})
	public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto){
		String token = authService.login(loginDto);
		//return ResponseEntity.ok(response); //at a place of token
		
		JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
		jwtAuthResponse.setAccessToken(token);
		
		return ResponseEntity.ok(jwtAuthResponse);
	}
    
	@Operation( //its for custamize documentaion
			summary = "User Sign-Up API",
			description = "The User Sign-Up API allows new users to create an account and "
					+ "register in the application."
		)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP Status 201 CREATED - User registration successful."
		)

    //build Signup api or register api
    
    @PostMapping({"/register","/signup"}) //value attribute
    public ResponseEntity<String> register(@RequestBody SignUpDto signUpDto){
		String response = authService.signUp(signUpDto);
		
    	return new ResponseEntity<>(response,HttpStatus.CREATED);
    	
    }
}

package net.javaguide.springboot.payload;

public class JWTAuthResponse {
  
	private String accessToken;
	private String tokenType = "Bearer";
	
	public String getAccessToken() {
		return accessToken;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	
	
	
	
}

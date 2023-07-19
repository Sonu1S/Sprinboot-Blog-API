package net.javaguide.sprinboot.miceroservices.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
 
	private LocalDateTime timestamp;
	private String message;
	private String path;
	private String errorCode;
	
	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorDetails(LocalDateTime timestamp, String message, String path, String errorCode) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.path = path;
		this.errorCode = errorCode;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getPath() {
		return path;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
}

package net.javaguide.springboot.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Schema( //We are providing User Dto model information
		description = "CommentDto Model Information"
		)
public class CommentDto {

	private long id;
	
	 @Schema( //We are providing User Dto model information
				description = "Blog Comment Name"
				)
	//name should not be null or empty
	@NotEmpty(message= "Name should not be null or Empty")
	
	private String name;
	//email shuld not be null or empty
	//email feild validation
	
	 @Schema( //We are providing User Dto model information
				description = "Blog Comment email"
				)
	@NotEmpty(message ="email shuld not be null or empty")
	@Email
	private String email;
	
	 @Schema( //We are providing User Dto model information
				description = "Blog Comment Body"
				)
	//comment bpdy shuld not be null or empty
	//comment body must be minimum 10 character
	@NotEmpty
	@Size(message ="comment body must be minimum 10 character")
	private String body;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

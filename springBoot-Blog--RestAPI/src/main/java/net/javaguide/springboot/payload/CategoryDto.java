package net.javaguide.springboot.payload;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema( //We are providing User Dto model information
		description = "CategoryDto Model Information"
		)
public class CategoryDto {

   private long id;
   
   @Schema( //We are providing User Dto model information
			description = "Blog category Name"
			)
   private String name;
   
   @Schema( //We are providing User Dto model information
			description = "Blog Category description"
			)
   private String description;
	   
	   
	public CategoryDto() {
	super();
  }
	
	
	public CategoryDto(long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}


	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	   
	   
}

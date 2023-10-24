package net.javaguide.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.javaguide.springboot.entity.Category;
import net.javaguide.springboot.payload.CategoryDto;
import net.javaguide.springboot.service.CategoryService;

@Tag(
		name = "Category Management",
		description = "Category Management - Facilitates CRUD operations for managing blog post "
				+ "categories. This includes creating new categories, updating existing ones, "
				+ "retrieving individual or all categories, and deleting specific categories or all"
				+ " categories in the system."
		)

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
   
	private CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	@Operation( //its for custamize documentaion
			summary = "Manage Blog Post Categories",
			description = "The Category API allows administrators to manage and organize blog posts "
					+ "into different categories. Users can retrieve a list of available categories"
					+ " and associate posts with specific categories, enhancing content organization"
					+ " and user navigation."
			)
			@ApiResponse(
			responseCode = "201",
			description = "HTTP Status 201 CREATED - Category successfully created or updated."
			)
	
	//build Add Category REST API
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto){
		CategoryDto savedCategory = categoryService.addCategory(categoryDto);
		return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
		
	}
	
	@Operation( //its for custamize documentaion
			  summary = "Get Category By Id Rest API",
			  description = "Get category By Id Rest API is Used to get a single Post from the database"
		)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS"
		)
	
	//Build Get Category REST API
	@GetMapping("{id}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable("id") Long categoryId){
		CategoryDto categoryDto = categoryService.getCategory(categoryId);
		return ResponseEntity.ok(categoryDto);
		//return new ResponseEntity<>(categoryDto, HttpStatus.OK);
		
	}
	
	@Operation( //its for custamize documentaion
			  summary = "GetAll Category Rest API",
			  description = "GetAll Category Rest API is Used to get a All Post Record from the database"
		)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS"
		)
	
	//Build GetAll Category REST API
	@GetMapping
	public ResponseEntity<List<CategoryDto>> getCategories(){
//		List<CategoryDto> listAllCategory = categoryService.getAllCategories();
//		return ResponseEntity.ok( listAllCategory);
		
//      this is for print the value on console
//		Category category = new Category();
//		category.setId(1);
//		category.setName("sonu");
//		category.setDescription("HII");
//		System.out.println(category.getId());
//		System.out.println(category.getDescription());
//		System.out.println(category.getName());
		
		return ResponseEntity.ok(categoryService.getAllCategories());
	}

	@Operation( //its for custamize documentaion
			  summary = "Update Category By Id Rest API",
			  description = "Update Category By Id Rest API is Used to update particular Post from the database"
		)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS"
		)
	
	  //Build Update Category REST API
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("{id}")
     public ResponseEntity<CategoryDto> updatedCategory(@RequestBody CategoryDto categoryDto,
    		 @PathVariable("id") Long categoryId){
    	 CategoryDto updatedCategory = categoryService.updatedCategory(categoryDto, categoryId);
		return ResponseEntity.ok(updatedCategory);
    	 
     }
	
	@Operation( //its for custamize documentaion
			  summary = "Delete Category By Id Rest API",
			  description = "Delete Category By Id Rest API is Used to Delete Post By Id from the database"
		)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS"
		)
	//Build Delete Category REST API
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId){
		categoryService.deleteCategoryById(categoryId);
		return ResponseEntity.ok("Category deleted successfully!.");
		
	}
	
}

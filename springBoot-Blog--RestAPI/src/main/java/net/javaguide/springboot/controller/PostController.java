package net.javaguide.springboot.controller;

//http://localhost:9090/swagger-ui/index.html#/user-controller/createUser //this is the url

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import net.javaguide.springboot.entity.Post;
import net.javaguide.springboot.payload.PostDto;
import net.javaguide.springboot.payload.PostResponse;
import net.javaguide.springboot.service.PostService;
import net.javaguide.springboot.utils.AppConstants;

@Tag(
		name = "Post Management",
		description = "Post Management - Handles CRUD operations for post resources, including "
				+ "creation, retrieval, update, and deletion."
		)

@RestController
@RequestMapping("/api/posts")
public class PostController {
   
	private PostService postservice;

	public PostController(PostService postservice) {
		super();
		this.postservice = postservice;
	}
	
	@Operation( //its for custamize documentaion
			  summary = "Create Post Rest API",
			  description = "Create Post API  is Used to save post into database"
		)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP Status 201 CREATED"
		)
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping //localhost:8080/api/posts
	public ResponseEntity<Object> createPost(@Valid @RequestBody PostDto postDto) {
		
		 try {
		        PostDto createdPost = postservice.CreatePost(postDto);
		        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
		    } catch (DataIntegrityViolationException ex) {
		        String errorMessage = ex.getMessage();
		        if (errorMessage.contains("Duplicate entry")) {

		            String finalErrorMessage = "A blog post with the title already exists.";
		            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(finalErrorMessage);
		        }

		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
		    }
	 // return new ResponseEntity<>(postservice.CreatePost(postDto),HttpStatus.CREATED);
	} 
	
	@Operation( //its for custamize documentaion
			summary = "Create Blog Post",
			description = "This API endpoint allows users to create and publish new blog posts on the"
					+ " platform. Upon successful submission, the post is stored in the database "
					+ "for later retrieval and viewing."
			)
			@ApiResponse(
			responseCode = "201",
			description = "HTTP Status 201 CREATED - Blog post successfully created."
			)
	
	//localhost:8080/api/posts?pageNo=0&pageSize=5
	//localhost:8080/api/posts?pageNo=0&pageSize=5&sortBy=title
	//localhost:8080/api/posts?pageNo=0&pageSize=5&sortBy=id&sortDir=desc
	
	@GetMapping 
	public PostResponse getAllPosts(
		@RequestParam(value = "pageNo",  defaultValue   = AppConstants.DEFAULT_PAGE_NUMBER,  required = false) int pageNo,
		@RequestParam(value = "pageSize",defaultValue   = AppConstants.DEFAULT_PAGE_SIZE,    required = false) int pageSize,
		@RequestParam(value = "sortBy",  defaultValue   = AppConstants.DEFAULT_SORT_BY,      required = false) String sortBy,
		@RequestParam(value = "sortDir", defaultValue   = AppConstants.DEFAULT_SORT_DIR,     required = false) String sortDir
		  ){
//		List<PostDto> postDto = postservice.getAllPosts();
//		return postDto;
		return postservice.getAllPosts(pageNo, pageSize, sortBy,sortDir);//we can  direcly written this
	}
	
	@Operation( //its for custamize documentaion
			  summary = "Get Post By Id Rest API",
			  description = "Get Post By Id Rest API is Used to get a single Post from the database"
		)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS"
		)
	
	@GetMapping("/{id}")//localhost:8080/api/posts/1
	public ResponseEntity<PostDto> getPostById(@PathVariable("id") long id){
		return ResponseEntity.ok(postservice.getPostById(id));
		
	}
	
	@Operation( //its for custamize documentaion
			  summary = "Update Post By Id Rest API",
			  description = "Update Post By Id Rest API is Used to update particular Post from the database"
		)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS"
		)
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}") //localhost:8080/api/posts/5
	public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto,@PathVariable("id") long id){
		PostDto dto = postservice.updatePost(postDto,id);
		return new ResponseEntity<PostDto>(dto,HttpStatus.OK);
		
	}
	
	@Operation( //its for custamize documentaion
			  summary = "Delete Post By Id Rest API",
			  description = "Delete Post By Id Rest API is Used to Delete Post By Id from the database"
		)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS"
		)
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")//localhost:8080/api/posts/5
    public ResponseEntity<String> deletePost(@PathVariable("id") long id){
      postservice.deletePost(id);
      return new ResponseEntity<>("Post Entity deleted successfully." ,HttpStatus.OK);
  	
    }
	
	@Operation( //its for custamize documentaion
			  summary = "Get Post Category By Id Rest API",
			  description = "Get POST Category By Id Rest API is Used to get a Post on the basis of Category from the database"
		)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS"
		)
	
	@GetMapping("/category/{id}")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable("id") Long categoryId) {
        List<PostDto> postDtos = postservice.getPostByCategoryId(categoryId);
        return ResponseEntity.ok(postDtos);
    }
	
	 
	//http://localhost:8080/api/posts/autosuggest?partialKeyword=Mp
	 @GetMapping("/search")
		public ResponseEntity<?> searchWithTitle(@RequestParam String partialKeyword) {
		 if (partialKeyword.length() < 2) {
	            return ResponseEntity.badRequest().body("Please provide a minimum of 2 characters.");
	        }

	        List<PostDto> suggestions = postservice. SearchWithTitle(partialKeyword);
	        
	        if (suggestions.isEmpty()) {
	            return ResponseEntity.ok("No details related to the provided search.");
	        }
	        return ResponseEntity.ok(suggestions);
	    
	    }
	 
	 @GetMapping("/filter")
	    public ResponseEntity<List<PostDto>> getFilteredPosts(@RequestParam(required = false) String title,
	                                                          @RequestParam(required = false) String content) {
	        List<PostDto> filteredPosts = postservice.getFilteredPosts(title, content);
	        return ResponseEntity.ok(filteredPosts);
	    }
  }
  
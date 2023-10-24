package net.javaguide.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import net.javaguide.springboot.payload.CommentDto;
import net.javaguide.springboot.service.CommentService;

@Tag(
		name = "Comment Management",
		description = "Comment Management - Manages CRUD operations for comment resources, "
				+ "encompassing creation, updating, retrieval of individual comments and all "
				+ "comments, as well as deletion of specific comments and all comments."
		)

@RestController
@RequestMapping("/api/")
public class CommentController {
  
	private CommentService commentService;
	
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	@Operation( //its for custamize documentaion
			summary = "Create Comment for Blog Post",
			description = "This API endpoint enables users to leave comments on specific blog posts."
					+ " The comment content is associated with the relevant post, allowing readers "
					+ "to engage in discussions and share their thoughts."
			)
			@ApiResponse(
			responseCode = "201",
			description = "HTTP Status 201 CREATED - Comment successfully added to the blog post."
			)
	
	//localhost:8080/api/posts/2/comments
	@PostMapping("posts/{postId}/comments")
	public ResponseEntity<CommentDto> createCommnet(@PathVariable("postId") long postId,
			@Valid @RequestBody CommentDto commentDto){
		CommentDto dto = commentService.createComment(postId, commentDto);
		return new ResponseEntity<>(dto,HttpStatus.CREATED);
	}
	
	@Operation( //its for custamize documentaion
			  summary = "GetAll Comment Rest API",
			  description = "GetAll Commnet Rest API is Used to get a All Post Record from the database"
		)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS"
		)
	//localhost:8080/api/posts/1/comments
	@GetMapping("posts/{postId}/comments")
	public List<CommentDto> getCommentsByPostId(@PathVariable(value="postId") long postId){
		return commentService.getCommentByPostId(postId);
		
	}
	
	@Operation( //its for custamize documentaion
			  summary = "GetComment By Id Rest API",
			  description = "Get Commnet By Id Rest API is Used to get a single Post from the database"
		)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS"
		)
	@GetMapping("/posts/{postId}/comments/{id}")
	public ResponseEntity<CommentDto> getCommentById(
	/*
	 * @PathVariable(value = "postId")Long postId,
	 * 
	 * @PathVariable(value = "id") Long commentId
	 */ ){
		return null;
//		CommentDto commentDto = commentService.getCommentById(postId, commentId);
//			return new ResponseEntity<>(commentDto, HttpStatus.OK);
		}
	 
	@Operation( //its for custamize documentaion
			  summary = "Update Commnet By Id Rest API",
			  description = "Update Commnet By Id Rest API is Used to update particular Post from the database"
		)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS"
		)
	//localhost:8080/api/posts/1/comments/2
	@PutMapping("/posts/{postId}/comments/{id}")
	public ResponseEntity<CommentDto> updateComment(@PathVariable(value="postId") long postId,
			@PathVariable(value="id")long commentId, 
			@Valid @RequestBody CommentDto commentDto){
		
		CommentDto updateComment = commentService.updateComment(postId, commentId, commentDto);
		  
		return new ResponseEntity<>(updateComment, HttpStatus.OK);
	}
	
	@Operation( //its for custamize documentaion
			  summary = "Delete Comment By Id Rest API",
			  description = "Delete Comment By Id Rest API is Used to Delete Post By Id from the database"
		)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS"
		)
	
	//localhost:8080/api/posts/2/comments/1
	@DeleteMapping("posts/{postId}/comments/{id}")
	public ResponseEntity<String> deleteComment(
			  @PathVariable("postId") long postId,
	          @PathVariable("id") long commentId
			){
		
		commentService.deleteComment(postId,commentId);
		return new ResponseEntity<String>("Comment is deleted!", HttpStatus.OK);
		
	}
}


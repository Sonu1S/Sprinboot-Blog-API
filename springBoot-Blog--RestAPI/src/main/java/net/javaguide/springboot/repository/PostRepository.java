package net.javaguide.springboot.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.javaguide.springboot.entity.Post;
import net.javaguide.springboot.payload.PostDto;

public interface PostRepository extends JpaRepository<Post, Long> {
	
	// Query method with JPQL query to find categories by categoryId
//    @Query("SELECT c FROM Category c WHERE c.id = :categoryId")
//    List<Post> findByCategoryId(@Param("categoryId") Long categoryId);

    	List<Post> findByCategoryId(Long categoryId);
    
	@Query("SELECT p.id, p.title, p.description, p.content, p.category.id FROM Post p WHERE LOWER"
			+ "(p.title) LIKE LOWER(CONCAT('%', :partialKeyword, '%'))")
	List<Object[]> findTop5ByTitleContainingIgnoreCase(@Param("partialKeyword") String partialKeyword);


    List<PostDto> findByTitleContainingAndContentContaining(String title, String content);
}

package com.ram.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ram.springboot.entity.Comment;
import com.ram.springboot.entity.Post;
import com.ram.springboot.repository.CommentRepository;
import com.ram.springboot.repository.PostRepository;

@SpringBootApplication
public class SpringbootHibernateOneManyMappingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateOneManyMappingApplication.class, args);
	}

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// Save comments to database
		Post post = new Post("One to many mapping using JPA and Hibernate", "One is too many mapping!");
		
		Comment comment1 = new Comment("Very Useful");
		Comment comment2 = new Comment("Informative");
		Comment comment3 = new Comment("Great post");
		
		// Add comments to the post
		post.getComments().add(comment1);
		post.getComments().add(comment2);
		post.getComments().add(comment3);
		
		// Save the Post entity to the database
		this.postRepository.save(post);
	}

}

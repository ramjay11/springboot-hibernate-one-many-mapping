package com.ram.springboot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {

	@Id // Make it primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;
	
	// OneToMany, one post can have many comments. Comment is child entity of Post
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "postcomment_foreignkey", referencedColumnName = "id") // Define the foreign key
	List<Comment> comments = new ArrayList<Comment>();
	
	public Post() {

	}
	
	public Post(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	// Getters and setters to access private fields
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
}

package com.ram.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ram.springboot.entity.Post;

// Access data from the database
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}

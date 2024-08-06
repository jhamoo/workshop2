package com.test.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.springbootapp.entity.Post;


public interface PostRepository
    extends JpaRepository<Post, Long> {
        //List<Post> getPostByFirstName(String firstName);
}
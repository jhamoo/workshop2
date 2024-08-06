package com.test.springbootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.springbootapp.dto.PostDto;
import com.test.springbootapp.service.PostService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(("/api/posts"))
public class PostController {

    @Autowired
    private PostService postService;

    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(
        @RequestBody PostDto postDto) {
        return new ResponseEntity<>(
            postService.createPost(postDto), HttpStatus.CREATED);
    }

}

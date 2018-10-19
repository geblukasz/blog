package com.akademiakodu.blog.controller;

import com.akademiakodu.blog.models.dto.PostDTO;
import com.akademiakodu.blog.repositories.PostRepository;
import com.akademiakodu.blog.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostRestController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostService postService;

    @Autowired
    ModelMapper modelMapper;


    @PostMapping("/api/post")
    public ResponseEntity<PostDTO> addPost (@RequestParam String title, String content, @RequestParam Long userId){
        PostDTO postDTO = postService.createPost(title, content, userId);
        return ResponseEntity.ok().body(postDTO);
    }
}

package com.akademiakodu.blog.controller;

import com.akademiakodu.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PostController {

    @Autowired
    PostRepository postRepository;

}

package com.akademiakodu.blog.service;

import com.akademiakodu.blog.models.dto.PostDTO;
import com.akademiakodu.blog.models.entities.Post;
import com.akademiakodu.blog.models.entities.User;
import com.akademiakodu.blog.repositories.PostRepository;
import com.akademiakodu.blog.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    PostRepository postRepository;
    UserRepository userRepository;
    ModelMapper modelMapper;

    @Autowired
    public PostService (PostRepository postRepository, UserRepository userRepository, ModelMapper modelMapper){
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public PostDTO createPost(String title, String content, Long userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        Post post = new Post(title, content);
        optionalUser.ifPresent(user -> post.setUser(user));

        postRepository.save(post);

        return modelMapper.map(post, PostDTO.class);

    }
}

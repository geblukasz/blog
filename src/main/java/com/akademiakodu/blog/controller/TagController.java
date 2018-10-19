package com.akademiakodu.blog.controller;

import com.akademiakodu.blog.models.dto.PostDTO;
import com.akademiakodu.blog.models.dto.TagDTO;
import com.akademiakodu.blog.models.entities.Post;
import com.akademiakodu.blog.models.entities.Tag;
import com.akademiakodu.blog.repositories.PostRepository;
import com.akademiakodu.blog.repositories.TagRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class TagController {

    @Autowired
    TagRepository tagRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<TagDTO> createTag(@RequestParam String tagName){
        Tag tag = new Tag();
        tag.setTagName(tagName);
        tagRepository.save(tag);

        TagDTO tagDTO = modelMapper.map(tag, TagDTO.class);

        return ResponseEntity.ok().body(tagDTO);
    }

    @PutMapping("/tag/addToPost")
    public ResponseEntity<PostDTO> addTagPost(@RequestParam Long tagId, @RequestParam Long postId){
        Tag tag = tagRepository.getOne(tagId);
        Post post = postRepository.getOne(tagId);
        post.getTags().add(tag);
        postRepository.save(post);
        return ResponseEntity.ok().body(modelMapper.map(post, PostDTO.class));
    }

    @GetMapping("tags")
    public List<Tag> getAllTags(){
        return tagRepository.findAll();
    }



}

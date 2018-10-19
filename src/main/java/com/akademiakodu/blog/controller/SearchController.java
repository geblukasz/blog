package com.akademiakodu.blog.controller;

import com.akademiakodu.blog.models.entities.Post;
import com.akademiakodu.blog.repositories.PostRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    PostRepository postRepository;

/*    public String search(@RequestParam String searchPhrase, Model model){
        List<Post> posts = postRepository.findAllByTitleContainsOrContentContains(searchPhrase, searchPhrase);
        model.addAttribute("posts", posts);
        model.addAttribute("searchPhrase",searchPhrase);

        return "posts";
    }*/
}

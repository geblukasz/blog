package com.akademiakodu.blog.controller;

import com.akademiakodu.blog.models.entities.Post;
import com.akademiakodu.blog.models.entities.PostComment;
import com.akademiakodu.blog.repositories.PostRepository;
import com.akademiakodu.blog.service.UserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

@Controller
public class MainController {

    private PostRepository postRepository;
    private UserSessionService userSessionService;

    @Autowired
    public MainController(PostRepository postRepository, UserSessionService userSessionService) {
        this.postRepository = postRepository;
        this.userSessionService = userSessionService;
    }

    @GetMapping("/")
    public String getIndexPage(Model model){
                                            //
        model.addAttribute("loggedUser", userSessionService.getUserDTO());
        model.addAttribute("name", "lukasz");
        return "index";

    }

    @PostMapping("/addPost")
    public String addPost(Model model, @RequestParam(value = "title") String titleParam, @RequestParam(value = "text") String content){
        System.out.println("Param: " + titleParam + "content: " + content);
        Post post = new Post(titleParam, content);

        PostComment postComment = new PostComment();
        postComment.setComment(titleParam);

        post.addComment(postComment);
        postRepository.save(post);

        return "index";

    }

    @GetMapping("/addPost")
    public String addPostPage(){
        return "addPost";
    }

    @GetMapping("/posts")
    public String postsPage(Model model){
        List<Post> postList = new ArrayList<>();
        Iterable<Post> postIterable = postRepository.findAll();
        for (Post post : postIterable){
            postList.add(post);
        }
        model.addAttribute("posts", postList);
        return "posts";
    }

/*    @GetMapping("/posts/{title}")
    public String postsByTitle(@PathVariable String title, Model model){
        List<Post> postList = new ArrayList<>();
        Iterable<Post> postIterable = postRepository.findAllByTitleContains(title);
        for (Post post : postIterable){
            postList.add(post);
        }

        model.addAttribute("posts", postList);
        return "posts";
    }

    @GetMapping("/posts/{title}/{sortField}/{sortDirection}")
    public String postsByTitle(@PathVariable String title,
                               @PathVariable String sortField,
                               @PathVariable String sortDirection,
                               Model model){

        Sort.Direction direction = Sort.Direction.ASC;
        if ("desc".equals(sortDirection)){
            direction = Sort.Direction.DESC;
        }

        List<Post> postList = postRepository.findAllByTitleContains(title, Sort.Direction.fromString(direction.toString()), sortField);
        model.addAttribute("posts", postList);
        return "posts";

    }*/
}

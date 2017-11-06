package com.codeup.blog.springbootblog.controllers;

import com.codeup.blog.springbootblog.models.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostsControllers {
    private final PostSvc postSvc;

    @Autowired
    public PostsControllers(PostSvc postSvc) {
        this.postSvc = postSvc;
    }



    @GetMapping("/posts")
    @ResponseBody
    public String posts(@PathVariable String posts, Model viewmodel)
    {
        ArrayList<String> post = new ArrayList<>();
        post.add("cat");
        post.add("dog");
        viewmodel.addAttribute("post", post);
        viewmodel.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String single(@PathVariable int id, Model viewmodel){


        viewmodel.addAttribute("single",id);
        return "show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String ViewCreate(){
        return "form to create a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String create(){
        return "Create post";
    }


}

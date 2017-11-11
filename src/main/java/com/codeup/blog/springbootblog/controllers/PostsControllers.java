package com.codeup.blog.springbootblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostsControllers {


    @GetMapping("/posts")
    @ResponseBody
    public String posts() {
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String single(){
        return "Individual post";
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

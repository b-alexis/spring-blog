package com.codeup.blog.springbootblog.controllers;

import com.codeup.blog.springbootblog.models.Post;
import com.codeup.blog.springbootblog.services.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostsControllers {
    private final PostSvc postSvc;

    //Constructor injection
    @Autowired
    public PostsControllers(PostSvc postSvc) {
        this.postSvc = postSvc;
    }


    @GetMapping("/posts")
    public String posts(Model viewmodel) {
//        ArrayList<String> post = new ArrayList<>();
//        post.add("cat");
//        post.add("dog");
//        viewmodel.addAttribute("post", post);
        viewmodel.addAttribute("posts", postSvc.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")

    public String single(@PathVariable int id, Model viewmodel) {


        viewmodel.addAttribute("post", postSvc.findOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String ViewCreate(Model vmodel) {
        vmodel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post) {
        postSvc.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(Model vmodel, @PathVariable long id) {
        Post existingPost = postSvc.findOne(id);
        vmodel.addAttribute("post", existingPost);
        return "posts/edit";
    }

    @PostMapping("posts/{id}/edit")
    public String submitEditForm(@PathVariable long id, @ModelAttribute Post post) {
        postSvc.update(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
        Post deletePost = postSvc.findOne(id);
        postSvc.delete(deletePost);
        return "redirect:/posts";
    }


}

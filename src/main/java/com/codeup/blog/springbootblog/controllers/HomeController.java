package com.codeup.blog.springbootblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 1. Add controller annotation
@Controller
public class HomeController {
    //4. Bind this method to a url pattern
    @GetMapping("/")
    //3. Add the response body annotation
    @ResponseBody
    //2. Create a regular method for your controller action
    public String indexPage() {
        return "This is the landing page";
    }


}

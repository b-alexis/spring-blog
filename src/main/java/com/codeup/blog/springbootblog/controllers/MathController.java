package com.codeup.blog.springbootblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {


    @GetMapping("/add/{firstNum}/and/{nextNum}")
    @ResponseBody
    public Double add(@PathVariable Double firstNum, @PathVariable Double nextNum){
        return  firstNum + nextNum;
    }

    @GetMapping("/subtract/{firstNum}/from/{nextNum}")
    @ResponseBody
    public Double subtract(@PathVariable Double firstNum, @PathVariable Double nextNum){
        return nextNum - firstNum;
    }

    @GetMapping("/multiply/{firstNum}/and/{nextNum}")
    @ResponseBody
    public Double multiply(@PathVariable Double firstNum, @PathVariable Double nextNum){
        return firstNum*nextNum;
    }

    @GetMapping("/divide/{firstNum}/by/{nextNum}")
    @ResponseBody
    public Double divide(@PathVariable Double firstNum, @PathVariable Double nextNum){
        return nextNum / firstNum;
    }



}

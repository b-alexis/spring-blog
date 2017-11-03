package com.codeup.blog.springbootblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DiceRollController {
    private int counter = 0;

    @GetMapping("/roll-dice")
    public String homepage() {
        return "roll-dice";
    }

        @GetMapping("/roll-dice/{guess}")
        public String guess (@PathVariable int guess, Model viewmodel){
            int random = (int) (Math.random() * 6 + 1);
            counter ++;
            viewmodel.addAttribute("counter",counter);
            viewmodel.addAttribute("guess", guess);
            viewmodel.addAttribute("random", random);
            return "roll-dice";
        }
    }




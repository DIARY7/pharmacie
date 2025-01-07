package com.gestionprojet.pharmacie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/")
    public ModelAndView showHome(){
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page", "pages/home");
        return mv;
    }
    
}

package com.memorynotfound.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
    @RequestMapping(value = {"/","/hello"}, method = RequestMethod.GET)
    public String index(ModelMap model){
        model.addAttribute("message", "Hello World");
        return "index";
    }
}

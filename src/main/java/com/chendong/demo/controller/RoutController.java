package com.chendong.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Controller
@RequestMapping("/view")
public class RoutController {

    @RequestMapping("/index")
    public String index(Model model) {

        model.addAttribute("msg", "hello world");
        return "index";
    }

    @RequestMapping("/add")
    public String add(Model model) {

        model.addAttribute("msg", "add hello world");
        return "user/add";
    }


    @RequestMapping("/update")
    public String update(Model model) {

        model.addAttribute("msg", "update hello world");
        return "user/update";
    }

}

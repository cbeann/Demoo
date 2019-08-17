package com.example.springsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author CBeann
 * @create 2019-08-16 19:58
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "login/mylogin";

    }


}

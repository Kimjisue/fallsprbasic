package com.thc.fallsprbasic.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {
    @GetMapping("/create") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public String create(){
        return "user/create";
    }
    @GetMapping("/list") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public String list(){
        return "user/list";
    }
    @GetMapping("/detail/{id}") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public String detail(@PathVariable String id){
        return "user/detail";
    }
    @GetMapping("/login") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public String login(){
        return "user/login";
    }

    @GetMapping("/signup") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public String signup(){
        return "user/signup";
    }

}


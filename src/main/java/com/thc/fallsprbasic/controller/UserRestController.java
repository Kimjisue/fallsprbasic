package com.thc.fallsprbasic.controller;

import com.thc.fallsprbasic.domain.User;
import com.thc.fallsprbasic.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/user")
@RestController
public class UserRestController {
    private final UserService userService;
    public UserRestController(
            UserService userService
    ) {
        this.userService = userService;
    }

    List<Map<String,Object>> userList = new ArrayList<>();
    @GetMapping("/login") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public Map<String, Object> login(@RequestParam Map<String , Object>params){
        return userService.loginUser(params);
    }
    @GetMapping("/list") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public List<User> list(){
        return userService.listUser();
    }

    @GetMapping("/detail") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public User detail(@RequestParam Integer num){
        return userService.detailUser(num);
    }
    @GetMapping("/update") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public Map<String,Object> update(@RequestParam Map<String,Object> params){
        return userService.updateUser(params);
    }
    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam Map<String, Object> params){
        return userService.deleteUser(Integer.parseInt(params.get("num") + ""));
    }
}

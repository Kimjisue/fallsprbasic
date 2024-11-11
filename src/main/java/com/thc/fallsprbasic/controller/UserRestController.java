package com.thc.fallsprbasic.controller;

import com.thc.fallsprbasic.domain.User;
import com.thc.fallsprbasic.dto.UserDto;
import com.thc.fallsprbasic.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
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

    @PostMapping("/create")
    public UserDto.CreateResDto create(@RequestBody UserDto.CreateReqDto param){
        return userService.create(param);
    }
    @GetMapping("/list")
    public List<User> list(){
        return userService.list();
    }
    @GetMapping("/detail") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public User detail(@RequestParam Long id){
        return userService.detail(id);
    }
    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params){
        return userService.update(params);
    }
    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam Map<String, Object> params){
        return userService.delete(Long.parseLong(params.get("id") + ""));
    }
    @PostMapping("/login")
    public UserDto.LoginResDto login(@RequestBody UserDto.LoginReqDto param){
        return userService.login(param);
    }

    @PostMapping("/signup")
    public UserDto.CreateResDto signup(@RequestBody UserDto.CreateReqDto param){
        return userService.signup(param);
    }
    @GetMapping("/id")
    public boolean signup(@RequestParam String username){
        return userService.id(username);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        System.out.println(filename);
        //위까지는 파일을 프론트에서 잘 전달해줌!!

        String filePath = "/Users/kimjisue/fallbasic/";
        File newfile = new File(filePath);
        // File 객체에 담긴 폴더가 존재하는지 물어봄!
        if(!newfile.exists()) {
            // File 객체에 담긴 폴더가 존재안하면 강제 생성!!
            newfile.mkdirs();
        }

        //파일명 중복을 막기 위해 현재 시각 가져오기!
        Date date = new Date();
        String temp_date = date.getTime() + "";
        String finalName = filePath + temp_date + "_" + filename;
        FileCopyUtils.copy(file.getBytes(), new File(finalName));

        return ResponseEntity.status(HttpStatus.OK).body(temp_date + "_" + filename);
    }
}
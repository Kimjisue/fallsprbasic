package com.thc.fallsprbasic.controller;

import com.thc.fallsprbasic.dto.DefaultDto;
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

@RequestMapping("/api/user")
@RestController
public class UserRestController {

    private final UserService userService;
    public UserRestController(
            UserService userService
    ) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<DefaultDto.CreateResDto> login(@RequestBody UserDto.LoginReqDto param){
        return ResponseEntity.ok(userService.login(param));
    }

    /**/
    @PostMapping("")
    public ResponseEntity<DefaultDto.CreateResDto> create(@RequestBody UserDto.CreateReqDto param){
        return ResponseEntity.ok(userService.create(param));
    }
    @PutMapping("")
    public ResponseEntity<String> update(@RequestBody UserDto.UpdateReqDto param){
        userService.update(param);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("")
    public ResponseEntity<String> delete(@RequestBody UserDto.UpdateReqDto param){
        userService.delete(param.getId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/detail")
    public ResponseEntity<UserDto.DetailResDto> detail(@RequestParam Long id){
        return ResponseEntity.ok(userService.detail(id));
    }
    @GetMapping("/list")
    public ResponseEntity<List<UserDto.DetailResDto>> list(UserDto.ListReqDto param){
        return ResponseEntity.ok(userService.list(param));
    }
    @GetMapping("/plist")
    public ResponseEntity<DefaultDto.PagedListResDto> plist(UserDto.PagedListReqDto param){
        return ResponseEntity.ok(userService.pagedList(param));
    }
    @GetMapping("/mlist")
    public ResponseEntity<List<UserDto.DetailResDto>> mlist(UserDto.ScrollListReqDto param){
        return ResponseEntity.ok(userService.scrollList(param));
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